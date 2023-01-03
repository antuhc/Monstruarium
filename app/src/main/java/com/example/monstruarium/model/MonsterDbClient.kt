package com.example.monstruarium.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MonsterDbClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl( "https://demo4724702.mockable.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(MonsterDbService::class.java)
}