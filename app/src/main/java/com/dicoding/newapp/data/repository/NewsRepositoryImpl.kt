package com.dicoding.newapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dicoding.newapp.data.remote.NewsApi
import com.dicoding.newapp.data.remote.NewsPagingSource
import com.dicoding.newapp.domain.model.Article
import com.dicoding.newapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun upsertArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getArticles(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArticle(url: String): Article? {
        TODO("Not yet implemented")
    }
}