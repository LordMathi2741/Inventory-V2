package com.me.lordmathi2741.employee.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.employee.R
import com.me.lordmathi2741.employee.models.Product
import com.me.lordmathi2741.employee.protoypes.ProductPrototype

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPrototype {
       val layout = LayoutInflater.from(parent.context).inflate(R.layout.inventory_card, parent, false)
        return ProductPrototype(layout)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductPrototype, position: Int) {
        holder.bind(products[position])
    }
}