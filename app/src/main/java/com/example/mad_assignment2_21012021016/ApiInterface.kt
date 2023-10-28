package com.example.mad_assignment2_21012021016

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") apiid: String,
        @Query("units") units:String
    ): Call<WeatherApp>
}
