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