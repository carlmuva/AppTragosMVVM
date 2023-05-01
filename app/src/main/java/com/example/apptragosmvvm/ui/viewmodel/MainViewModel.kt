package com.example.apptragosmvvm.ui.viewmodel

import androidx.lifecycle.*
import com.example.apptragosmvvm.domain.Repo
import com.example.apptragosmvvm.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo):ViewModel(){

    private val tragoNameData = MutableLiveData<String>()

    fun setTrago(tragoName:String){
        tragoNameData.value = tragoName
    }

    init {
        setTrago("mojito")
    }

    val fetchTragosList = tragoNameData.distinctUntilChanged().switchMap { tragoName ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(tragoName))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

}