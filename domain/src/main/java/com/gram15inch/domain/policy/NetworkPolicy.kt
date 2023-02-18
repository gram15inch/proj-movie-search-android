package com.gram15inch.domain.policy

import com.gram15inch.domain.BuildConfig
import retrofit2.Response

object NetworkPolicy {
    const val NAVER_BASE_URL = "https://openapi.naver.com/"

    const val NAVER_HEADER_CLIENT_ID = "X-Naver-Client-Id:${BuildConfig.NAVER_CLIENT_ID}"
    const val NAVER_HEADER_CLIENT_SECRET = "X-Naver-Client-Secret:${BuildConfig.NAVER_CLIENT_SECRET}"

}

class ResponseException(message: String) : Exception(message)
enum class ResponseState{SUCCESS,ERROR,NONE}

fun <T> responseErrorHandle(response:Response<T>):T{
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
