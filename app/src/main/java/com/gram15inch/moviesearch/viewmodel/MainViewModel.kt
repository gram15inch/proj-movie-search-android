package com.gram15inch.moviesearch.viewmodel

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.gram15inch.domain.model.Movie
import com.gram15inch.moviesearch.base.ErrorHandleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ErrorHandleViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()
    val searchCurrent = MutableStateFlow("")


    fun refreshMovie(size:Int) {
        viewModelScope.launch {
            _movies.emit(getMovieList(size))
        }
    }

    fun refreshRecentSearch(recent:String){
        viewModelScope.launch {
            searchCurrent.emit(recent)
        }
    }
    private fun getMovieList(size:Int): List<Movie> {

        val movies = mutableListOf<Movie>()

        repeat(size) {
            movies.add(
                Movie(
                    it,
                    "아바타 $it",
                    "2022",
                    "https://movie-phinf.pstatic.net/20221215_185/1671091761840XXpCR_JPEG/movie_image.jpg?type=m203_290_2",
                    "https://movie.naver.com/movie/bi/mi/basic.naver?code=74977#",
                    5.0f
                )
            )
        }

        return movies
    }


}