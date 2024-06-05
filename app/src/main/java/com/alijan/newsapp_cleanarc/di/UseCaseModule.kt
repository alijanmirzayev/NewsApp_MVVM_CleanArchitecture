package com.alijan.newsapp_cleanarc.di

import com.alijan.newsapp_cleanarc.domain.repository.NewsRepository
import com.alijan.newsapp_cleanarc.domain.usecase.GetNewsByHeadline
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsByHeadline(newsRepository: NewsRepository): GetNewsByHeadline {
        return GetNewsByHeadline(newsRepository)
    }
}