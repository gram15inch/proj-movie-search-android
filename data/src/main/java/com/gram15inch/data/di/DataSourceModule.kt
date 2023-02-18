package com.gram15inch.data.di

import com.gram15inch.data.repository.datasource.MovieLocalDataSource
import com.gram15inch.data.datasource.local.movie.MovieLocalDataSourceImpl
import com.gram15inch.data.repository.datasource.MovieRemoteDataSource
import com.gram15inch.data.datasource.remote.movie.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMovieLocalDataSource(movieLocalDataSourceImpl: MovieLocalDataSourceImpl)
            : MovieLocalDataSource

    @Binds
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl)
            : MovieRemoteDataSource

}