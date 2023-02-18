package com.gram15inch.data.datasource.local.movie

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gram15inch.data.datasource.local.movie.model.LocalRecentSearch


@Dao
interface MovieDao {

    @Query("SELECT * FROM LocalRecentSearch ORDER BY rid DESC LIMIT 10")
    fun selectRecentSearches(): List<LocalRecentSearch>

    @Insert
    fun insertRecentSearches(recentSearch: LocalRecentSearch)

    @Delete
    fun deleteRecentSearches(user: LocalRecentSearch)
}