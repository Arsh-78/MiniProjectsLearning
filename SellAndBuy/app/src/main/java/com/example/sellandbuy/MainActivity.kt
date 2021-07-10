package com.example.sellandbuy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sellandbuy.ui.BuyFragment
import com.example.sellandbuy.ui.MyCustomActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this, MyCustomActivity::class.java)
            startActivity(intent)
        }
    }
}
