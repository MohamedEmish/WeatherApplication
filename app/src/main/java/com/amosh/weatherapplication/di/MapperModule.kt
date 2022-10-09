package com.amosh.weatherapplication.di

import com.amosh.common.Mapper
import com.amosh.data.mapper.WeatherDataDomainMapper
import com.amosh.data.model.WeatherDTO
import com.amosh.domain.entity.WeatherEntity
import com.amosh.feature.mapper.WeatherDomainUiMapper
import com.amosh.feature.model.WeatherUiModel
import com.amosh.local.mapper.WeatherLocalDataMapper
import com.amosh.local.model.WeatherLocalModel
import com.amosh.remote.mapper.WeatherNetworkDataMapper
import com.amosh.remote.model.WeatherResponseNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module that holds Mappers
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    //region Locale Mappers
    @Binds
    abstract fun bindsWeatherLocalDataMapper(mapper : WeatherLocalDataMapper) : Mapper<WeatherLocalModel, WeatherDTO>
    //endregion


    //region Data Mappers
    @Binds
    abstract fun bindsWeatherDataDomainMapper(mapper : WeatherDataDomainMapper) : Mapper<WeatherDTO, WeatherEntity>
    //endregion


    //region Presentation Mappers
    @Binds
    abstract fun bindsWeatherDomainUiMapper(mapper : WeatherDomainUiMapper) : Mapper<WeatherEntity, WeatherUiModel>
    //endregion


    //region Remote Mappers
    @Binds
    abstract fun bindsWeatherNetworkDataMapper(mapper: WeatherNetworkDataMapper): Mapper<WeatherResponseNetwork, WeatherDTO>
    //endregion

}