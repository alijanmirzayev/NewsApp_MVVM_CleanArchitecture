package com.alijan.newsapp_cleanarc.data.source.remote

import com.alijan.newsapp_cleanarc.data.api.APIServices
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor (private val apiServices: APIServices) : RemoteDataSource {

    override suspend fun getNewsByTopHeadline(
        country: String,
        query: String,
        apiKey: String
    ): Response<ArticlesResponse> = apiServices.getNewsByTopHeadline(
        country,
        query,
        apiKey
    )


}