package com.dicoding.newapp.domain.usecase.app_entry

import com.dicoding.newapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(private  val localUserManger: LocalUserManger
){
     operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}