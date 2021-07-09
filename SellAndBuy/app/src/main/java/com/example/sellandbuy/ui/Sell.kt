package com.example.sellandbuy.ui

import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sellandbuy.R
import kotlinx.android.synthetic.main.fragment_sell.*


class Sell : Fragment() {

    private lateinit var viewModel: SellerVIewModel
    private val adapter = ProductListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel=ViewModelProvider(this).get(SellerVIewModel::class.java)
        return inflater.inflate(R.layout.fragment_sell, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyler_view_ourProducts.adapter=adapter

        viewModel.fetchProduct()
        viewModel.products.observe(viewLifecycleOwner, Observer {
            adapter.setProducts(it)

        })

        add_button.setOnClickListener{
           DiaglogFragmentAddSell().show(childFragmentManager,"")
        }

    }


}