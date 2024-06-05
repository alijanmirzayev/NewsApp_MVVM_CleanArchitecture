package com.alijan.newsapp_cleanarc.di

import com.alijan.newsapp_cleanarc.data.api.APIServices
import com.alijan.newsapp_cleanarc.data.repository.NewsRepositoryImpl
import com.alijan.newsapp_cleanarc.data.source.remote.RemoteDataSource
import com.alijan.newsapp_cleanarc.data.source.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiServices: APIServices): RemoteDataSource {
        return RemoteDataSourceImpl(apiServices)
    }

}