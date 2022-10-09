package com.amosh.domain.repository

import com.amosh.common.Resource
import com.amosh.domain.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

/**
 * Methods of Repository
 */
interface Repository {

    suspend fun getWeather(city:String) : Flow<Resource<WeatherEntity>>

}