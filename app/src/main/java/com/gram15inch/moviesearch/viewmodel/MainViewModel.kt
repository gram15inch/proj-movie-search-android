package com.gram15inch.moviesearch.viewmodel

import androidx.lifecycle.viewModelScope
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.repository.MovieRepository
import com.gram15inch.moviesearch.base.ErrorHandleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ErrorHandleViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    private var movieTotalCount = 0
    val searchCurrent = MutableStateFlow("")
    fun refreshMovie() {
        viewModelScope.launch(exceptionHandler) {
            movieRepository.getMovies(searchCurrent.value, 1).also {
                if (it.isNotEmpty()) {
                    movieTotalCount = it.first().total
                    _movies.emit(it)
                } else {
                    clearMovie()
                }
            }
        }
    }

    fun refreshMoreMovie() {
        viewModelScope.launch(exceptionHandler) {
            val list = mutableListOf<Movie>()
            list.addAll(_movies.value)
            if (movieTotalCount > list.size) {
                list.addAll(movieRepository.getMovies(searchCurrent.value, list.size + 1))
                _movies.emit(list)
            }
        }
    }

    fun refreshRecentSearch(recent: String) {
        val current = viewModelScope.async {
            searchCurrent.emit(recent)
        }
        viewModelScope.launch {
            current.await()
            refreshMovie()
            addRecentSearch()
        }
    }

    fun addRecentSearch() {
        CoroutineScope(Dispatchers.IO).launch {
            movieRepository.addRecentSearch(searchCurrent.value)
        }
    }
    fun clearMovie(){
        viewModelScope.launch {
            movieTotalCount =0
            _movies.emit(emptyList())
        }
    }
    @Suppress("unused")
    private fun getMovieList(size: Int): List<Movie> {

        val movies = mutableListOf<Movie>()

        repeat(size) {
            movies.add(
                Movie(
                    "아바타 $it",
                    "2022",
                    "https://movie-phinf.pstatic.net/20221215_185/1671091761840XXpCR_JPEG/movie_image.jpg?type=m203_290_2",
                    "https://movie.naver.com/movie/bi/mi/basic.naver?code=74977#",
                    5.0f,
                    1
                )
            )
        }

        return movies
    }

}