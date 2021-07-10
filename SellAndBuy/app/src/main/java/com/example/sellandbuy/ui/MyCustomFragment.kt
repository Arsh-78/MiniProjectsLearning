package com.example.sellandbuy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sellandbuy.R
import kotlinx.android.synthetic.main.fragment_sell.*
import kotlinx.android.synthetic.main.mycustom_fragment.*

class MyCustomFragment :Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.mycustom_fragment, container, false)

     



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sell_button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_myCustomFragment_to_sell)
        }

        buy_button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_myCustomFragment_to_buyFragment)
        }
    }
}