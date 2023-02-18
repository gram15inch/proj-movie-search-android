package com.gram15inch.data.repository.datasource

import com.gram15inch.data.datasource.local.movie.model.LocalRecentSearch


interface MovieLocalDataSource {
    suspend fun selectRecentSearch():List<LocalRecentSearch>
    suspend fun insertRecentSearches(title:String)
    suspend fun deleteRecentSearches(rid:Int)
}

