package com.example.movieapp.home.data

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(private val services: ServicesAPI) {
    suspend fun getActors() =
        withContext(Dispatchers.IO) {
            services.getActors()
        }
}