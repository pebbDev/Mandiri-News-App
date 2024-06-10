package com.dicoding.newapp.domain.usecase.news

import com.dicoding.newapp.data.local.dao.NewsDao
import com.dicoding.newapp.domain.model.Article
import javax.inject.Inject

class GetSavedArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}