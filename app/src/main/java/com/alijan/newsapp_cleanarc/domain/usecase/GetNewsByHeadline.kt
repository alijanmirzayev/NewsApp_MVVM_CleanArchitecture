package com.alijan.newsapp_cleanarc.domain.usecase

import com.alijan.newsapp_cleanarc.common.base.NetworkResponse
import com.alijan.newsapp_cleanarc.data.model.ArticlesResponse
import com.alijan.newsapp_cleanarc.domain.repository.NewsRepository

class GetNewsByHeadline(private val newsRepository: NewsRepository) {

    suspend fun execute(
        country: String,
        query: String,
        apiKey: String
    ): NetworkResponse<ArticlesResponse> {
        return newsRepository.getNewsByTopHeadline(country, query, apiKey)
    }

}