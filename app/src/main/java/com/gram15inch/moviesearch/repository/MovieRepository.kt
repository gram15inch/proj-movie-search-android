package com.gram15inch.moviesearch.repository

import com.gram15inch.moviesearch.model.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>
}
