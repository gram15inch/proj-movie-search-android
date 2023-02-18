package com.gram15inch.moviesearch.viewmodel

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.repository.MovieRepository
import com.gram15inch.moviesearch.base.ErrorHandleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ErrorHandleViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()
    val searchCurrent = MutableStateFlow("아바타")

    fun refreshMovie() {
        viewModelScope.launch(exceptionHandler) {
            //_movies.emit(getMovieList(size)) 테스트용
            _movies.emit(movieRepository.getMovies(searchCurrent.value))
        }
    }

    fun refreshRecentSearch(recent: String) {
        val current= viewModelScope.async {
            searchCurrent.emit(recent)
        }
        viewModelScope.launch {
            current.await()
            refreshMovie()
            addRecentSearch()
        }

    }

    fun addRecentSearch(){
        CoroutineScope(Dispatchers.IO).launch {
            movieRepository.addRecentSearch(searchCurrent.value)
        }
    }

    private fun getMovieList(size: Int): List<Movie> {

        val movies = mutableListOf<Movie>()

        repeat(size) {
            movies.add(
                Movie(
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