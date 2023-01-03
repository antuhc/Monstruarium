package com.example.monstruarium.model

import retrofit2.Call
import retrofit2.http.GET

interface MonsterDbService {
    @GET("/index")
    // Suspender la corrutina y recupera la peticion del servidor con retrofit
    suspend fun listMonsters(): MonsterDbResult
}
