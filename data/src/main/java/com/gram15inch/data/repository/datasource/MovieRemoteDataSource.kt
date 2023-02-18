package com.gram15inch.data.repository.datasource

import com.gram15inch.data.datasource.remote.movie.model.RemoteMovie

interface MovieRemoteDataSource {
   suspend fun getMovies(query:String):List<RemoteMovie>
}