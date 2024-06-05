package com.alijan.newsapp_cleanarc.domain.repository

import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse

interface NewsRepository {

    suspend fun getNewsByTopHeadline(
        country: String,
        category: String
    ): NetworkResponse<ArticlesResponse>

}