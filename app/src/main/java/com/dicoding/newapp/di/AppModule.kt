package com.dicoding.newapp.di

import android.app.Application
import com.dicoding.newapp.data.manger.LocalUserMangerImpl
import com.dicoding.newapp.domain.manger.LocalUserManger
import com.dicoding.newapp.domain.usecase.app_entry.AppEntryUseCase
import com.dicoding.newapp.domain.usecase.app_entry.ReadAppEntry
import com.dicoding.newapp.domain.usecase.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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

}