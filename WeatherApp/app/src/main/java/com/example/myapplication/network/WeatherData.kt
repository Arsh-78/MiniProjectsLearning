package com.example.myapplication.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.json.JSONArray



data class WeatherData (@Json(name = "weather") val  weatheri: List<Weather>) {

    data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    )
}