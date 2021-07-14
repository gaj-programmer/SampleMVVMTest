package com.example.testsample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.example.WeatherApiResult
import com.example.testsample.R
import com.example.testsample.databinding.ActivityMainBinding
import com.example.testsample.ui.viewmodel.WeatherInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Project           : SampleMVVM
 * File Name         : WeatherInfoActivity
 * Description       :
 * Revision History  : version 1
 * Date              : 13/07/21
 * Original author   : Gajraj
 */
@AndroidEntryPoint
class WeatherInfoActivity : AppCompatActivity() {
    private val TAG: String ="MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherInfoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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

}