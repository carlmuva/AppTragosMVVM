package com.example.apptragosmvvm.domain

import com.example.apptragosmvvm.data.model.DataSource
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {

    override fun getTragosList(): Resource<List<Drink>> {
        return dataSource.providerTragosList
    }
}