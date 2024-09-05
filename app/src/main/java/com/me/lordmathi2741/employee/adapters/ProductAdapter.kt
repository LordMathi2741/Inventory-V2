package com.me.lordmathi2741.employee.adapters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.employee.InventoryDetailsActivity
import com.me.lordmathi2741.employee.R
import com.me.lordmathi2741.employee.models.Product
import com.me.lordmathi2741.employee.protoypes.ProductPrototype


class ProductAdapter(private val context: Context, private val products: List<Product>) : RecyclerView.Adapter<ProductPrototype>() {
    private var onItemClick : ((Product) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPrototype {
       val layout = LayoutInflater.from(parent.context).inflate(R.layout.inventory_card, parent, false)
        return ProductPrototype(layout)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductPrototype, position: Int) {
      holder.bind(products[position])
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(products[position])
            val intent = Intent(context, InventoryDetailsActivity::class.java).apply {
                putExtra("product_name", products[position].name)
                putExtra("product_price", products[position].price)
                putExtra("product_quantity", products[position].quantity)
                putExtra("product_image", products[position].imgUrl)
            }

            context.startActivity(intent)
        }
    }
}
