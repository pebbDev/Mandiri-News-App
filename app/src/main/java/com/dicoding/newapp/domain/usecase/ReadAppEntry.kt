package com.dicoding.newapp.domain.usecase

import com.dicoding.newapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private  val localUserManger: LocalUserManger
){
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}