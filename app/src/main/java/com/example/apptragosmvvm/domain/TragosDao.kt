package com.example.apptragosmvvm.domain

import androidx.room.*
import com.example.apptragosmvvm.data.model.DrinkEntity

@Dao
interface TragosDao {

    @Query("SELECT * FROM drinkentity")
    suspend fun getFavoriteAllDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteTrago(trago:DrinkEntity)

/*    @Delete
    suspend fun delete(drink: DrinkEntity)*/

}