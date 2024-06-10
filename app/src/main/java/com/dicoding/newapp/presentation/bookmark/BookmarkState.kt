package com.dicoding.newapp.presentation.bookmark

import com.dicoding.newapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)