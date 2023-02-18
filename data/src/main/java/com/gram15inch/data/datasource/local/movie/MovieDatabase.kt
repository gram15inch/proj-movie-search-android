package com.gram15inch.data.datasource.local.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gram15inch.data.datasource.local.movie.model.LocalRecentSearch

@Database(entities = [LocalRecentSearch::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun userDao(): MovieDao
}