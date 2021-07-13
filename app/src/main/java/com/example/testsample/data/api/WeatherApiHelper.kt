package com.example.testsample.data.api

/**
 * Project           : SampleMVVM
 * File Name         : WeatherApiHelper
 * Description       :
 * Revision History  : version 1
 * Date              : 13/07/21
 * Original author   : Gajraj
 */
open class WeatherApiHelper(private val apiService: WeatherApiService) {

    suspend fun getWeatherInfo(city: String,appId:String) = apiService.getWeatherInfo(city,appId)

}