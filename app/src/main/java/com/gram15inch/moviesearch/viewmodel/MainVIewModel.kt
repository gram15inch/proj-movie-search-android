package com.gram15inch.moviesearch.viewmodel

import com.gram15inch.moviesearch.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVIewModel @Inject constructor(private val movieRepository: MovieRepository)  {


}