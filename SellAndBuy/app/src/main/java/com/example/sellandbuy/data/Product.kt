package com.example.sellandbuy.data

import com.google.firebase.database.Exclude

data class Product (
    @get:Exclude
    var id:String?=null,
    var name:String?=null

)