package com.gram15inch.data.datasource.remote.movie

import com.gram15inch.data.datasource.remote.movie.model.MovieResponse
import com.gram15inch.data.policy.NetworkPolicy

import retrofit2.Response
import retrofit2.http.*

interface MovieApiService {
    @Headers(
        NetworkPolicy.NAVER_HEADER_CLIENT_ID,
        NetworkPolicy.NAVER_HEADER_CLIENT_SECRET
    )
    @GET("v1/search/movie.json")
    suspend fun getMovies(
        @Query("query") query:String,
    ): Response<MovieResponse>

}