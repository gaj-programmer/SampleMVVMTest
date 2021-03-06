package com.example.testsample.data.repository

import com.example.testsample.data.api.WeatherApiHelper
import javax.inject.Inject

/**
 * Project           : SampleMVVM
 * File Name         : WeatherRepository
 * Description       :
 * Revision History  : version 1
 * Date              : 13/07/21
 * Original author   : Gajraj
 */
class WeatherRepository @Inject constructor(private val weatherApiHelper: WeatherApiHelper) {

    suspend fun getWeatherInfo(city: String, appId: String) = weatherApiHelper.getWeatherInfo(city, appId)
}