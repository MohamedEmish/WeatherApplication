package com.amosh.data.repository

import com.amosh.data.model.WeatherDTO

/**
 * Methods of Remote Data Source
 */
interface RemoteDataSource {

    suspend fun getWeather(city:String) : WeatherDTO

}