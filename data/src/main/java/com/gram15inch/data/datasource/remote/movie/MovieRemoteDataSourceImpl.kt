package com.gram15inch.data.datasource.remote.movie

import com.gram15inch.data.datasource.remote.movie.model.MovieResponse
import com.gram15inch.data.policy.responseErrorHandle
import com.gram15inch.data.repository.datasource.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieApiService: MovieApiService) :
    MovieRemoteDataSource {

   override suspend fun getMovieResponse(query: String, start: Int): MovieResponse {
        movieApiService.getMovies(query, start).apply {
           return responseErrorHandle(this)
        }
   }
}