package com.gram15inch.moviesearch.viewmodel

import androidx.lifecycle.viewModelScope
import com.gram15inch.moviesearch.base.ErrorHandleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentSearchViewModel @Inject constructor() :ErrorHandleViewModel() {
    private val _recentSearches = MutableStateFlow<List<String>>(emptyList())
    val recentSearches = _recentSearches.asStateFlow()

    init {
        patchRecentSearches()
    }

    private fun patchRecentSearches(){
        viewModelScope.launch {
          _recentSearches.emit(listOf("아바타","공조7","박물관이 살아있다","타이타닉","교섭","스톰보이"))
        }
    }
}