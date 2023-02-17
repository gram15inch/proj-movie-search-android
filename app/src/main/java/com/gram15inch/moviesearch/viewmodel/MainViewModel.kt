package com.gram15inch.moviesearch.viewmodel

import com.gram15inch.moviesearch.base.ErrorHandleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() :ErrorHandleViewModel()  {

fun getTestString()="MainViewModelString"
}