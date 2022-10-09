package com.amosh.remote.source

import com.amosh.common.Mapper
import com.amosh.data.model.WeatherDTO
import com.amosh.data.repository.RemoteDataSource
import com.amosh.remote.api.ApiService
import com.amosh.remote.model.WeatherResponseNetwork
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val apiService: ApiService,
    private val weatherMapper: Mapper<WeatherResponseNetwork, WeatherDTO>,
) : RemoteDataSource {


    override suspend fun getWeather(city: String): WeatherDTO {
        val networkData = apiService.getWeather(city = city)
        return weatherMapper.from(networkData)
    }
}