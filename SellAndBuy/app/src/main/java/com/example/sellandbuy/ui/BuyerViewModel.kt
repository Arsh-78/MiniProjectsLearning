package com.example.sellandbuy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sellandbuy.data.NODE_SELLER
import com.example.sellandbuy.data.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BuyerViewModel:ViewModel() {

    val dbproducts = FirebaseDatabase.getInstance().getReference(NODE_SELLER)

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
        get() = _products

    fun fetchProduct()
    {
        dbproducts.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val products = mutableListOf<Product>()
                    for(productSnapshot in snapshot.children)
                    {
                        val product = productSnapshot.getValue(Product::class.java)
                        product ?.id = productSnapshot.key
                        product?.let { products.add(it) }
                    }
                    _products.value=products
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}