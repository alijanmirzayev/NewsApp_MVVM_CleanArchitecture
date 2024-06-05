package com.alijan.newsapp_cleanarc.data.repository

import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import com.alijan.newsapp_cleanarc.data.source.remote.RemoteDataSource
import com.alijan.newsapp_cleanarc.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    NewsRepository {

    override suspend fun getNewsByTopHeadline(
        country: String,
        query: String,
    ): NetworkResponse<ArticlesResponse> {
        return withContext(Dispatchers.IO){
            val response = remoteDataSource.getNewsByTopHeadline(country, query)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@withContext NetworkResponse.Success(it)
                }
            }
            return@withContext NetworkResponse.Error(response.message())
        }
    }
}