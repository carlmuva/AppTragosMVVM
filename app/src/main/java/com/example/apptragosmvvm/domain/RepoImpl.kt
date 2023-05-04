package com.example.apptragosmvvm.domain

import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.data.model.DrinkEntity
import com.example.apptragosmvvm.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {

    suspend override fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        dataSource.insertTragoIntoRoom(trago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return dataSource.getTragosFavoritos()
    }
}