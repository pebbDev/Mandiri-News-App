package com.dicoding.newapp.presentation.detail.components

import com.dicoding.newapp.domain.model.Article

sealed class DetailsEvent {

    object SaveArticle : DetailsEvent()

}