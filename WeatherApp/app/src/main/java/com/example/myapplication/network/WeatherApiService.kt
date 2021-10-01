package com.example.myapplication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET


private const val BASE_URL =
"https://api.openweathermap.org/"




private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeatherApiService {
    val a: String
    @GET("data/2.5/weather?q=London&appid=573dbbc49c2ddaefb5e658496caa1533")
    suspend fun getWeather(): WeatherData
}
object WeatherApi
{
    val retrofitService : WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }

}
