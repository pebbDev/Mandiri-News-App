package com.dicoding.newapp.presentation.detail

import com.dicoding.newapp.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}