package com.dicoding.newapp.presentation.search

import androidx.paging.PagingData
import com.dicoding.newapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)