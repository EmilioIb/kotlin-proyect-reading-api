package com.example.ejemplo.di

import com.example.ejemplo.provider.PerrosProvider
import com.example.ejemplo.repository.PerrosRepository
import com.example.ejemplo.repository.PerrosRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import javax.inject.Named
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providerPerrosRepository(provider: PerrosProvider): PerrosRepository =
        PerrosRepositoryImp(provider)
}