package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.WeatherApi
import com.example.myapplication.network.WeatherApiService


import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private  val _status = MutableLiveData<String>()

    val status : LiveData<String> = _status

    init {
        getWeatherData()
    }



    private  fun getWeatherData()
    {
       viewModelScope.launch {
           try{
               val listresult = WeatherApi.retrofitService.getWeather()
               _status.value =listresult.weatheri[0].main
           }catch (e:Exception)
           {
               _status.value = "Failure: ${e.message}"
           }

       }
    }
}




