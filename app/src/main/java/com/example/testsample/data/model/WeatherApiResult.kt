package com.example.example

import com.example.testsample.data.model.Main
import com.google.gson.annotations.SerializedName

   
data class WeatherApiResult (

   @SerializedName("coord") var coord : Coord,
   @SerializedName("weather") var weather : List<Weather>,
   @SerializedName("base") var base : String,
   @SerializedName("main") var main : Main,
   @SerializedName("visibility") var visibility : Int,
   @SerializedName("wind") var wind : Wind,
   @SerializedName("clouds") var clouds : Clouds,
   @SerializedName("dt") var dt : Int,
   @SerializedName("sys") var sys : Sys,
   @SerializedName("timezone") var timezone : Int,
   @SerializedName("id") var id : Int,
   @SerializedName("name") var name : String,
   @SerializedName("cod") var cod : Int

)