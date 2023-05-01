package com.example.apptragosmvvm.data.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    val imagen : String = "",
    val nombre : String = "",
    val descripcion : String = ""
):Parcelable
