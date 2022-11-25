package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val services: ServicesAPI) {

    suspend fun getActors() =
        withContext(Dispatchers.IO) {
            services.getActors()
        }

    suspend fun getTopMovies() =
        withContext(Dispatchers.IO) {
            services.getTopMovies()
        }


}