package com.example.apptragosmvvm.data.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    @SerializedName("strDrinkThumb")
    val imagen : String = "",
    @SerializedName("strDrink")
    val nombre : String = "",
    @SerializedName("strInstructions")
    val descripcion : String = ""
):Parcelable

data class DrinkList(
    @SerializedName("drinks")
    val drinksList:List<Drink> = listOf()
)
