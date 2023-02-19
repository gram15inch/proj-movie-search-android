package com.gram15inch.moviesearch.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gram15inch.domain.policy.ResponseException
import com.gram15inch.domain.policy.ResponseState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.net.SocketException
import java.net.UnknownHostException

abstract class ErrorHandleViewModel : ViewModel() {
    val responseState = MutableStateFlow(ResponseState.NONE)
    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        viewModelScope.launch {
            when (throwable) {
                is ResponseException ->{
                    responseState.emit(ResponseState.ERROR)
                }
                else ->{
                    responseState.emit(ResponseState.ERROR)
                }
            }
        }
    }

}
