package com.dicoding.newapp.domain.usecase.news

import com.dicoding.newapp.data.local.NewsDao
import com.dicoding.newapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}