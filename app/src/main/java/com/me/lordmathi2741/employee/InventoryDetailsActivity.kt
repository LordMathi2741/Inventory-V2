package com.me.lordmathi2741.employee

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class InventoryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inventory_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productName = intent.getStringExtra("product_name")
        val productPrice = intent.getDoubleExtra("product_price", 0.0)
        val productQuantity = intent.getIntExtra("product_quantity", 0)
        val productImage = intent.getStringExtra("product_image")

        val productNameTextView = findViewById<TextView>(R.id.tvProductNameDetail)
        val productPriceTextView = findViewById<TextView>(R.id.tvProductPriceDetail)
        val productQuantityTextView = findViewById<TextView>(R.id.tvProductQuantityDetail)
        val productImageView = findViewById<ImageView>(R.id.ivPrductImageDetail)

        productNameTextView.text = productName
        productPriceTextView.text = productPrice.toString()
        productQuantityTextView.text = productQuantity.toString()
        Glide.with(this).load(productImage).into(productImageView)





    }
}