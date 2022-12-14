package com.amosh.feature.ui.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.amosh.base.BaseViewModel
import com.amosh.common.Mapper
import com.amosh.common.Resource
import com.amosh.domain.entity.WeatherEntity
import com.amosh.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import com.amosh.feature.ui.contract.MainContract
import com.amosh.feature.model.WeatherUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherMapper: Mapper<WeatherEntity, WeatherUiModel>,
) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    override fun createInitialState(): MainContract.State {
        return MainContract.State(
            weatherState = MainContract.WeatherState.Idle,
            selectedWeather = null
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.OnFetchWeather -> {
                fetchWeather(event.city)
            }
            is MainContract.Event.OnWeatherItemClicked -> {
                val item = event.weather
                setSelectedPost(weather = item)
            }
        }
    }

    /**
     * Fetch posts
     */
    private fun fetchWeather(city: String) {
        viewModelScope.launch {
            getWeatherUseCase.execute(city)
                .onStart { emit(Resource.Loading) }
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            // Set State
                            setState { copy(weatherState = MainContract.WeatherState.Loading) }
                        }
                        is Resource.Empty -> {
                            // Set State
                            setState { copy(weatherState = MainContract.WeatherState.Idle) }
                        }
                        is Resource.Success -> {
                            // Set State
                            val weatherList = weatherMapper.fromList(listOf(it.data))
                            setState {
                                copy(
                                    weatherState = MainContract.WeatherState.Success(
                                        weatherList = weatherList
                                    )
                                )
                            }
                        }
                        is Resource.Error -> {
                            // Set Effect
                            setEffect { MainContract.Effect.ShowError(message = it.exception.message) }
                        }
                    }
                }
        }
    }

    /**
     * Set selected post item
     */
    private fun setSelectedPost(weather: WeatherUiModel?) {
        // Set State
        setState { copy(selectedWeather = weather) }
    }
}