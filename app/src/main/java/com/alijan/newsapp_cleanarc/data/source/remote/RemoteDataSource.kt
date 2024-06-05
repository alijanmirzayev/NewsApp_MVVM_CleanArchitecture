package com.alijan.newsapp_cleanarc.data.source.remote

import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getNewsByTopHeadline(
        country: String,
        category: String
    ): Response<ArticlesResponse>

}

