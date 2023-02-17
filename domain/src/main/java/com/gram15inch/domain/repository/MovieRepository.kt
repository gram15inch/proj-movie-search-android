package com.gram15inch.domain.repository
import com.gram15inch.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>
}
