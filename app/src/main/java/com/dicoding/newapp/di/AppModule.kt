package com.dicoding.newapp.di

import android.app.Application
import androidx.room.Room
import com.dicoding.newapp.data.local.NewsDao
import com.dicoding.newapp.data.local.NewsDatabase
import com.dicoding.newapp.data.local.NewsTypeConvertor
import com.dicoding.newapp.data.manger.LocalUserMangerImpl
import com.dicoding.newapp.data.remote.NewsApi
import com.dicoding.newapp.data.repository.NewsRepositoryImpl
import com.dicoding.newapp.domain.manger.LocalUserManger
import com.dicoding.newapp.domain.repository.NewsRepository
import com.dicoding.newapp.domain.usecase.app_entry.AppEntryUseCase
import com.dicoding.newapp.domain.usecase.app_entry.ReadAppEntry
import com.dicoding.newapp.domain.usecase.app_entry.SaveAppEntry
import com.dicoding.newapp.domain.usecase.news.DeleteArticle
import com.dicoding.newapp.domain.usecase.news.GetArticle
import com.dicoding.newapp.domain.usecase.news.GetArticles
import com.dicoding.newapp.domain.usecase.news.GetNews
import com.dicoding.newapp.domain.usecase.news.NewsUseCases
import com.dicoding.newapp.domain.usecase.news.SearchNews
import com.dicoding.newapp.domain.usecase.news.UpsertArticle
import com.dicoding.newapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCase = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi,newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getArticles = GetArticles(newsDao),
            getArticle = GetArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}