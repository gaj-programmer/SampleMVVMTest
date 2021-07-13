package com.example.testsample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.example.WeatherApiResult
import com.example.testsample.R
import com.example.testsample.data.api.WeatherApiHelper
import com.example.testsample.data.repository.WeatherRepository
import com.example.testsample.data.api.RetrofitInstance
import com.example.testsample.data.api.WeatherApiService
import com.example.testsample.databinding.ActivityMainBinding
import com.example.testsample.ui.viewmodel.WeatherInfoViewModel

class WeatherInfoActivity : AppCompatActivity() {
    private val TAG: String ="MainActivity"
    private lateinit var viewModel: WeatherInfoViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()
        initObserver()
        viewModel.fetchWeatherInfo()
    }

    private fun initObserver() {
        viewModel.responseData.observe(this, Observer {
            Log.i(TAG, "Response:$it")
            updateUI(it)
        })
    }

    private fun updateUI(it: WeatherApiResult?) {
        binding.tvValueTemp.text = it?.main?.temp.toString()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(WeatherInfoViewModel::class.java)
        val apiInterface = RetrofitInstance.retrofitInstance?.create(WeatherApiService::class.java)!!
        viewModel.weatherRepository = WeatherRepository(WeatherApiHelper(apiInterface))
    }
}