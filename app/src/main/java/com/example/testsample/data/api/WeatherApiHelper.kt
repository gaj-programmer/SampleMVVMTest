package com.example.testsample.data.api

open class WeatherApiHelper(private val apiService: WeatherApiService) {

    suspend fun getWeatherInfo(city: String,appId:String) = apiService.getWeatherInfo(city,appId)

}