package com.alijan.newsapp_cleanarc.data.repository

import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import com.alijan.newsapp_cleanarc.data.source.remote.RemoteDataSource
import com.alijan.newsapp_cleanarc.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    NewsRepository {

    override suspend fun getNewsByTopHeadline(
        country: String,
        query: String,
        apiKey: String
    ): NetworkResponse<ArticlesResponse> {
        val response = remoteDataSource.getNewsByTopHeadline(country, query, apiKey)
        if (response.isSuccessful) {
            response.body()?.let {
                return NetworkResponse.Success(it)
            }
        }
        return NetworkResponse.Error(response.message())
    }
}