package com.example.apptragosmvvm.data.model

import com.example.apptragosmvvm.AppDatabase
import com.example.apptragosmvvm.vo.Resource
import com.example.apptragosmvvm.vo.RetrofitClient

class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getTragoByName(nombreTrago:String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByName(nombreTrago).drinksList)
    }

    suspend fun insertTragoIntoRoom(trago: DrinkEntity){
        appDatabase.tragoDao().insertFavorite(trago)
    }

    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragoDao().getAllFavoriteDrinks())
    }

/*    val providerTragosList =Resource.Success( listOf(
        Drink("https://www.cocinavital.mx/wp-content/uploads/2018/03/margarita_tradicional-e1582054510330.jpg", "Margarita", "Con azucar, vodka y nueces"),
        Drink("https://fredystucan.com/wp-content/uploads/2021/07/Chocomilk.jpg", "Chocomilk", "Leche con chocolate"),
        Drink("https://www.comedera.com/wp-content/uploads/2022/04/Limonada-shutterstock_379385302.jpg", "Limonada", "Agua con limon y azucar"),
        Drink("https://chanfle.mx/wp-content/uploads/El_puesto_de_aguas_frescas_1974.jpg", "Agua del chavo del 8", "Agua que no se sabe de que sabor es")
    ))*/


}