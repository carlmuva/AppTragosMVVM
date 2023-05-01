package com.example.apptragosmvvm.domain

import com.example.apptragosmvvm.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php?s=")
    suspend fun getTragoByName(@Query(value = "tragoName") tragoName:String): DrinkList

}