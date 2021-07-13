package com.example.testsample.data.repository

import com.example.testsample.data.api.WeatherApiHelper

class WeatherRepository(private val weatherApiHelper: WeatherApiHelper) {

    suspend fun getWeatherInfo(city: String, appId: String) = weatherApiHelper.getWeatherInfo(city, appId)
}