package com.amosh.remote.api

import com.amosh.remote.BuildConfig
import com.amosh.remote.model.WeatherResponseNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = BuildConfig.API_KEY,
        @Query("units") units: String = "metric",
    ): WeatherResponseNetwork
}