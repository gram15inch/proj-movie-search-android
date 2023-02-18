package com.gram15inch.domain.repository
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.model.RecentSearch

interface MovieRepository {
    suspend fun getMovies(query:String):List<Movie>
    suspend fun addRecentSearch(title:String)

    suspend fun getRecentSearches():List<RecentSearch>
}
