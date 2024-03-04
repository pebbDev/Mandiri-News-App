package com.dicoding.newapp.domain.usecase.news

import com.dicoding.newapp.data.local.NewsDao
import com.dicoding.newapp.domain.model.Article

class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}