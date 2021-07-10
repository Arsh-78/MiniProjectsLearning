package com.example.sellandbuy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sellandbuy.R
import com.example.sellandbuy.data.Product
import kotlinx.android.synthetic.main.item_sell.view.*

class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.ProductViewModel>() {

    private var products = mutableListOf<Product>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= ProductViewModel(
        LayoutInflater.from(parent.context).inflate(R.layout.item_sell,parent,false)
    )

    override fun onBindViewHolder(holder: ProductListAdapter.ProductViewModel, position: Int) {
        holder.view.textView1.text=products[position].name
        holder.view.textView2.text=products[position].selname
        holder.view.textView3.text=products[position].phno
        holder.view.textView4.text=products[position].price
        holder.view.textView5.text=products[position].desc

    }

    override fun getItemCount(): Int {
       return products.size
    }

    fun setProducts(products : List<Product>)
    {
        this.products=products as MutableList<Product>
        notifyDataSetChanged()
    }
    class ProductViewModel(val view: View):RecyclerView.ViewHolder(view)

}