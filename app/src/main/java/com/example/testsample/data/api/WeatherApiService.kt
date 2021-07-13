package com.example.testsample.data.api

import com.example.example.WeatherApiResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("data/2.5/weather")
    suspend fun getWeatherInfo(@Query("q") city:String,@Query("appid") appId:String): Response<WeatherApiResult>
}