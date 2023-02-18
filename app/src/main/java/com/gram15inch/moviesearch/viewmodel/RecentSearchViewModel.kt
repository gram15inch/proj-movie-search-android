package com.gram15inch.moviesearch.viewmodel

import androidx.lifecycle.viewModelScope
import com.gram15inch.domain.model.RecentSearch
import com.gram15inch.domain.repository.MovieRepository
import com.gram15inch.moviesearch.base.ErrorHandleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentSearchViewModel @Inject constructor(private val movieRepository: MovieRepository) :ErrorHandleViewModel() {
    private val _recentSearches = MutableStateFlow<List<RecentSearch>>(emptyList())
    val recentSearches = _recentSearches.asStateFlow()

    init {
        patchRecentSearches()
    }

    private fun patchRecentSearches(){
        CoroutineScope(Dispatchers.IO).launch {
         // _recentSearches.emit(listOf("아바타","공조7","박물관이 살아있다","타이타닉","교섭","스톰보이"))
            movieRepository.getRecentSearches().also {
                _recentSearches.emit(it)
            }
        }
    }
}