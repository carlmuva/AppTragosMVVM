package com.example.apptragosmvvm.domain

import androidx.room.*
import com.example.apptragosmvvm.data.model.DrinkEntity

@Dao
interface TragosDao {


    @Query("SELECT * FROM tragosEntity")
    suspend fun getAllFavoriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertFavorite(trago:DrinkEntity)

/*    @Delete
    suspend fun delete(drink: DrinkEntity)*/

}