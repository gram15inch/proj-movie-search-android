package com.gram15inch.data.datasource.local.movie

import com.gram15inch.data.datasource.local.movie.model.LocalRecentSearch
import com.gram15inch.data.repository.datasource.MovieLocalDataSource
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val movieDatabase: MovieDatabase) : MovieLocalDataSource {
    override suspend fun selectRecentSearch(): List<LocalRecentSearch> {
       return movieDatabase.movieDao().selectRecentSearches()
    }

    override suspend fun insertRecentSearches(title:String) {
        movieDatabase.movieDao().insertRecentSearches(LocalRecentSearch(title=title))
    }

    override suspend fun deleteRecentSearches(rid:Int) {
        movieDatabase.movieDao().deleteRecentSearches(LocalRecentSearch(rid))
    }
}