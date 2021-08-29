package com.example.newsify.domain.model

data class Article(
    val author: String? = null,
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: Source = Source(),
    val title: String = "",
    val url: String = "",
    val urlToImage: Any? = null
)