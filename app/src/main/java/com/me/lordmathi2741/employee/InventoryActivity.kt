package com.me.lordmathi2741.employee

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.employee.adapters.ProductAdapter
import com.me.lordmathi2741.employee.service.ProductService
import com.me.lordmathi2741.employee.singleton.Configuration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class InventoryActivity : AppCompatActivity() {
    private lateinit var productService: ProductService
    private var configuration = Configuration.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inventory)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        productService = configuration.setUpRetrofit()
        lifecycleScope.launch {
            configuration.getProducts(productService)
        }

        lifecycleScope.launch {
            setUpInventoryRecyclerView()
        }


    }


    private suspend fun setUpInventoryRecyclerView(){
        val inventoryRecyclerView = findViewById<RecyclerView>(R.id.rvInventory)
        val context = this
        inventoryRecyclerView.layoutManager = LinearLayoutManager(context)
        withContext(Dispatchers.Main){
            inventoryRecyclerView.adapter = ProductAdapter(context,configuration.getProducts(productService))
        }

    }




}