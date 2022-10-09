package com.amosh.remote.model

data class SysNetwork(
    val country: String,
    val id: Int,
    val sunrise: Long,
    val sunset: Long,
    val type: Int,
)