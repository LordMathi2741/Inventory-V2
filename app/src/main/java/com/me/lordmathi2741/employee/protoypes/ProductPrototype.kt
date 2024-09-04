package com.me.lordmathi2741.employee.protoypes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.me.lordmathi2741.employee.R
import com.me.lordmathi2741.employee.models.Product

class ProductPrototype(itemView: View) :RecyclerView.ViewHolder(itemView){
    val tvName = itemView.findViewById<TextView>(R.id.tvProductName)
    val tvPrice = itemView.findViewById<TextView>(R.id.tvProductPrice)
    val tvQuantity = itemView.findViewById<TextView>(R.id.tvProductQuantity)
    val ivImage = itemView.findViewById<ImageView>(R.id.ivProductImage)


    fun bind(product: Product) {
        tvName.text = product.name
        tvPrice.text = product.price.toString()
        tvQuantity.text = product.quantity.toString()
        Glide.with(itemView.context)
            .load(product.imgUrl)
            .into(ivImage)

    }


}