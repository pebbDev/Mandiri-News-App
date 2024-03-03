package com.dicoding.newapp.di

import android.app.Application
import com.dicoding.newapp.data.manger.LocalUserMangerImpl
import com.dicoding.newapp.domain.manger.LocalUserManger
import com.dicoding.newapp.domain.usecase.AppEntryUseCase
import com.dicoding.newapp.domain.usecase.ReadAppEntry
import com.dicoding.newapp.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ):LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEnteryUseCase(
        localUserManger: LocalUserManger
    )= AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}