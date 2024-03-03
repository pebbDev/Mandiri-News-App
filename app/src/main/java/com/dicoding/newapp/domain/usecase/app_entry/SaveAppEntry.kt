package com.dicoding.newapp.domain.usecase.app_entry

import com.dicoding.newapp.domain.manger.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(private  val localUserManger: LocalUserManger
){
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}