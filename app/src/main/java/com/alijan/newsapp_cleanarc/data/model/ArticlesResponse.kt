package com.alijan.newsapp_cleanarc.data.model


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("articles")
    val articles: List<Article?>?,
)