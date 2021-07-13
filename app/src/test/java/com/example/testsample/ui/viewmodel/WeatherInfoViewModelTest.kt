package com.example.testsample.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testsample.data.api.WeatherApiHelper
import com.example.testsample.data.repository.WeatherRepository
import com.example.testsample.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class WeatherInfoViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var weatherApiHelper: WeatherApiHelper


    @Test
    fun testServerResponseError(){
        testCoroutineRule.runBlockingTest {

            val errorMessage = "Error Test"
            doThrow(RuntimeException(errorMessage))
                .`when`(weatherApiHelper).getWeatherInfo("Ajmer","1a33bc270227041a6cbb5dd0159ed646")

            val viewModel = WeatherInfoViewModel()
            Assert.assertNotNull(viewModel)
            viewModel.weatherRepository = WeatherRepository(weatherApiHelper)

            viewModel.fetchWeatherInfo()
            verify(weatherApiHelper).getWeatherInfo("Ajmer","1a33bc270227041a6cbb5dd0159ed646")

        }
    }

    @Test
    fun testServerResponseSuccess(){
        testCoroutineRule.runBlockingTest {
            doReturn(mock(Response::class.java))
                .`when`(weatherApiHelper).getWeatherInfo("Ajmer","1a33bc270227041a6cbb5dd0159ed646")

            val viewModel = WeatherInfoViewModel()
            Assert.assertNotNull(viewModel)
            viewModel.weatherRepository = WeatherRepository(weatherApiHelper)

            viewModel.fetchWeatherInfo()
            verify(weatherApiHelper).getWeatherInfo("Ajmer","1a33bc270227041a6cbb5dd0159ed646")
        }
    }
}