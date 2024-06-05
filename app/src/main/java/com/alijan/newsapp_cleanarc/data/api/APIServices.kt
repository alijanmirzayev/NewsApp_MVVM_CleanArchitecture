package com.alijan.newsapp_cleanarc.data.api

import com.alijan.newsapp_cleanarc.common.utils.Constant
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {

    @GET("top-headlines")
    suspend fun getNewsByTopHeadline(
        @Query("country")
        country: String = "us",
        @Query("category")
        category: String,
        @Query("apiKey")
        apiKey: String = "61932618445b4349be6e8182a4ddf2e1"
    ): Response<ArticlesResponse>

}