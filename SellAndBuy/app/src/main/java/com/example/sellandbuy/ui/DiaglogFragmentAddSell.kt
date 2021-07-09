package com.example.sellandbuy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.sellandbuy.R
import com.example.sellandbuy.data.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_diaglog_add_sell.*
import kotlinx.android.synthetic.main.fragment_sell.*


class DiaglogFragmentAddSell : DialogFragment() {

    private  lateinit  var viewModel : SellerVIewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE,android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
        viewModel =ViewModelProvider(this).get(SellerVIewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diaglog_add_sell, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner, Observer {
            val message = if(it==null)
            {
                "Author Added"
            }else
            {
                "Some Error Occured"
            }
            Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
            dismiss()
        })

        Add_Input_Name.setOnClickListener{
            val name = edit_text_name.text.toString()
            if(name.isEmpty())
            {
                input_layout_Name.error="This field required"
                return@setOnClickListener
            }

            val product = Product()
            product.name= name


            viewModel.addsSale(product)
        }
    }



}