package com.amosh.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amosh.local.model.WeatherLocalModel

@Database(entities = [WeatherLocalModel::class], version = 1, exportSchema = false) // We need migration if increase version
abstract class AppDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDAO
}