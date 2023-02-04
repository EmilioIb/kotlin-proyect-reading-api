package com.example.ejemplo.repository

import android.util.Log
import com.example.ejemplo.model.Perros
import com.example.ejemplo.provider.PerrosProvider
import javax.inject.Inject

interface PerrosRepository {
    suspend fun getPerros():List<Perros>
}

class PerrosRepositoryImp @Inject constructor(
    private val perrosProvider: PerrosProvider
): PerrosRepository{

    private var perros: List<Perros> = emptyList()

    override suspend fun  getPerros(): List<Perros>{
        val perroResponse = perrosProvider.getListPerros().body()

        perros = perroResponse?.items ?: emptyList()
        return perros
    }
}