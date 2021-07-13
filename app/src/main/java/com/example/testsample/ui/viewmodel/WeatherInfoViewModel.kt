package com.example.testsample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.WeatherApiResult
import com.example.testsample.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Project           : SampleMVVM
 * File Name         : WeatherInfoViewModel
 * Description       :
 * Revision History  : version 1
 * Date              : 13/07/21
 * Original author   : Gajraj
 */
class WeatherInfoViewModel : ViewModel() {
    val responseData = MutableLiveData<WeatherApiResult>()
    lateinit var weatherRepository:WeatherRepository

    fun fetchWeatherInfo(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = weatherRepository.getWeatherInfo("Ajmer","1a33bc270227041a6cbb5dd0159ed646")
            if(response.isSuccessful){
                responseData.postValue(response.body())
            }
        }
    }

}