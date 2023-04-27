package com.example.apptragosmvvm.domain

import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.vo.Resource

interface Repo {
    fun getTragosList():Resource<List<Drink>>
}