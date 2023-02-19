package com.gram15inch.data.repository.datasource

import com.gram15inch.data.datasource.remote.movie.model.MovieResponse

interface MovieRemoteDataSource {
   suspend fun getMovieResponse(query: String, start: Int): MovieResponse
}