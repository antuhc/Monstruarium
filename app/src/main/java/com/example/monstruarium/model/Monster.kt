package com.example.monstruarium.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Monster(
    val cover: String,
    val cult: String,
    val description: String,
    val genre: String,
    val habitat: String,
    val id: Int,
    val name: String,
    val race: String,
    val weapons: String
) : Parcelable