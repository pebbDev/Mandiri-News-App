package com.dicoding.newapp.data.remote.dto

import com.dicoding.newapp.domain.model.Article


data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)