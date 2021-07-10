package com.example.sellandbuy.data

import com.google.firebase.database.Exclude

data class Product (
    @get:Exclude
    var id:String?=null,
    var name:String?=null,
    var selname:String?=null,
    var price:String?=null,
    var phno:String?=null,
    var desc:String?=null
)