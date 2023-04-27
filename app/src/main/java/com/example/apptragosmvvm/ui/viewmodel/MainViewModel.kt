package com.example.apptragosmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.apptragosmvvm.domain.Repo
import com.example.apptragosmvvm.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo):ViewModel(){

    val fetchTragosList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getTragosList())
        }catch (e: java.lang.Exception){
            emit(Resource.Failure(e))
        }
    }

}