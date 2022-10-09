package com.amosh.feature.core

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToEgyptianDateTimeDefaults(): String {
    val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
    return sdf.format(this)
}

