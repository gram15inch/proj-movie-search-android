package com.gram15inch.data.repository

import com.gram15inch.data.mapper.toMovie
import com.gram15inch.data.mapper.toRecentSearch
import com.gram15inch.data.repository.datasource.MovieLocalDataSource
import com.gram15inch.data.repository.datasource.MovieRemoteDataSource
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.model.RecentSearch
import com.gram15inch.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(query:String): List<Movie> {
        return movieRemoteDataSource.getMovies(query).map { toMovie(it) }
    }

    override suspend fun getRecentSearches(): List<RecentSearch> {
        return movieLocalDataSource.selectRecentSearch().map { toRecentSearch(it)}
    }

    override suspend fun addRecentSearch(title: String) {
        movieLocalDataSource.insertRecentSearches(title)
    }
}