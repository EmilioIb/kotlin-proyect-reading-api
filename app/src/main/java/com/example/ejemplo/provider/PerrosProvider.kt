package com.example.ejemplo.provider

import com.example.ejemplo.model.PerrosApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface PerrosProvider {

    @GET("/API/")
    suspend fun getListPerros() : Response<PerrosApiResponse>

}