package com.amosh.feature.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.amosh.base.BaseRecyclerAdapter
import com.amosh.feature.databinding.RowWeatherItemLayoutBinding
import com.amosh.feature.model.WeatherUiModel

/**
 * Adapter class for RecyclerView
 */
class WeatherAdapter constructor(
    private val clickFunc: ((WeatherUiModel?) -> Unit)? = null,
) : BaseRecyclerAdapter<WeatherUiModel, RowWeatherItemLayoutBinding, WeatherViewHolder>(WeatherItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = RowWeatherItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherViewHolder(binding = binding, click = clickFunc)
    }

}

class WeatherItemDiffUtil : DiffUtil.ItemCallback<WeatherUiModel>() {
    override fun areItemsTheSame(oldItem: WeatherUiModel, newItem: WeatherUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WeatherUiModel, newItem: WeatherUiModel): Boolean {
        return oldItem == newItem
    }
}