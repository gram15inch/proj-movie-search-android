package com.gram15inch.data.policy

import com.gram15inch.domain.policy.ResponseException
import retrofit2.Response

fun <T> responseErrorHandle(response: Response<T>):T{
    if(response.isSuccessful)
        response.body().also {
            if(it!=null)
                return it
            else
                throw ResponseException("바디없음")
        }
    else {
        throw ResponseException("서버 연결실패 ${response.errorBody()}")
    }
}
