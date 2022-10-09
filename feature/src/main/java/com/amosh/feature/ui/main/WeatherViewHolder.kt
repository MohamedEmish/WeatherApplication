package com.amosh.feature.ui.main

import com.amosh.base.BaseViewHolder
import com.amosh.common.loadImagesWithGlideExt
import com.amosh.feature.databinding.RowWeatherItemLayoutBinding
import com.amosh.feature.model.WeatherUiModel

/**
 * ViewHolder class for Weather
 */
class WeatherViewHolder constructor(
    private val binding: RowWeatherItemLayoutBinding,
    private val click: ((WeatherUiModel?) -> Unit)? = null,
) : BaseViewHolder<WeatherUiModel, RowWeatherItemLayoutBinding>(binding) {

    init {
        binding.tvSeeMore.setOnClickListener {
            click?.invoke(getRowItem())
        }
    }

    override fun bind() {
        getRowItem()?.let {
            binding.weather = it
            val iconUrl = "https://openweathermap.org/img/w/${it.icon}.png"
            binding.imgIcon.loadImagesWithGlideExt(iconUrl)
            binding.executePendingBindings()
        }
    }
}