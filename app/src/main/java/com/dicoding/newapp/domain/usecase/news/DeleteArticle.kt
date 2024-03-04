package com.dicoding.newapp.domain.usecase.news

import com.dicoding.newapp.data.local.NewsDao
import com.dicoding.newapp.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}