package com.amosh.feature.ui.contract


import com.amosh.base.UiEffect
import com.amosh.base.UiEvent
import com.amosh.base.UiState
import com.amosh.feature.model.WeatherUiModel

/**
 * Contract of Main Screen
 */
class MainContract {

    sealed class Event : UiEvent {
        data class OnFetchWeather(val city: String) : Event()
        data class OnWeatherItemClicked(val weather: WeatherUiModel) : Event()
    }

    data class State(
        val weatherState: WeatherState,
        val selectedWeather: WeatherUiModel? = null,
    ) : UiState

    sealed class WeatherState {
        object Idle : WeatherState()
        object Loading : WeatherState()
        data class Success(val weatherList: List<WeatherUiModel>) : WeatherState()
    }

    sealed class Effect : UiEffect {

        data class ShowError(val message: String?) : Effect()

    }
}