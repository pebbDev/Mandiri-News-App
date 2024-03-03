package com.dicoding.newapp.domain.usecase

import com.dicoding.newapp.domain.manger.LocalUserManger

class SaveAppEntry (private  val localUserManger: LocalUserManger
){
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}