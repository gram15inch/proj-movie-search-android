package com.gram15inch.data.datasource.remote.movie

import com.gram15inch.data.datasource.remote.movie.model.RemoteMovie
import com.gram15inch.data.policy.responseErrorHandle
import com.gram15inch.data.repository.datasource.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieApiService: MovieApiService) :
    MovieRemoteDataSource {

   override suspend fun getMovies(query:String):List<RemoteMovie>{
        movieApiService.getMovies(query).apply {
           return responseErrorHandle(this).items
        }
   }
}