package com.dicoding.newapp.domain.manger

import kotlinx.coroutines.flow.Flow

interface LocalUserManger {
     suspend fun saveAppEntry()

     fun readAppEntry(): Flow<Boolean>

}