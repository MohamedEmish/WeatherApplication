package com.amosh.domain.usecase

import com.amosh.common.Resource
import com.amosh.domain.entity.WeatherEntity
import com.amosh.domain.qualifiers.IoDispatcher
import com.amosh.domain.repository.Repository
import com.amosh.domain.usecase.core.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Use Case class for get Weather
 */
class GetWeatherUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : BaseUseCase<WeatherEntity, String>() {

    override suspend fun buildRequest(params: String?): Flow<Resource<WeatherEntity>> {
        if (params == null) {
            return flow {
                emit(Resource.Error(Exception("id can not be null")))
            }.flowOn(dispatcher)
        }
        return repository.getWeather(params).flowOn(dispatcher)
    }
}