package com.dicoding.newapp.domain.usecase.news

import com.dicoding.newapp.data.local.dao.NewsDao
import com.dicoding.newapp.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}