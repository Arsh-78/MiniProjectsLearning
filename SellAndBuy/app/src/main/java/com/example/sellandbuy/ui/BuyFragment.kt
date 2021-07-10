package com.example.sellandbuy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sellandbuy.R
import kotlinx.android.synthetic.main.fragment_buy.*
import kotlinx.android.synthetic.main.fragment_sell.*


class BuyFragment : Fragment() {

    private lateinit var viewModel: BuyerViewModel
    private val adapter = ProductListAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel= ViewModelProvider(this).get(BuyerViewModel::class.java)
        return inflater.inflate(R.layout.fragment_buy, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyler_view_byourProducts.adapter=adapter

        viewModel.fetchProduct()
        viewModel.products.observe(viewLifecycleOwner, Observer {
            adapter.setProducts(it)

        })


    }



}