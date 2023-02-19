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
        when(response.code()){
            400->{throw ResponseException("요청값 오류")}
            403->{throw ResponseException("api 권한없음")}
            404->{throw ResponseException("존재하지 않는 api")}
            500->{throw ResponseException("시스템 에러")}
            else->{
                throw ResponseException("요청 실패 code:${response.code()}")
            }
        }
    }
}
