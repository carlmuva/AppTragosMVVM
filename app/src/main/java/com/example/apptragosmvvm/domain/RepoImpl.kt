package com.example.apptragosmvvm.domain

import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {

    suspend override fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }
}