package com.example.newsify.domain.model

data class NewsDataClass(
    val articles: List<Article> = listOf(),
    val status: String = "",
    val totalResults: Int = 0
)