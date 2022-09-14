package com.example.movieapp.auth.data

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val services: ServicesAPI) {

    suspend fun login(map:Map<String,String>) =
        withContext(Dispatchers.IO) {
            services.login(map)
        }
    suspend fun register(registerRequest: RegisterRequest) =
        withContext(Dispatchers.IO) {
            services.register(registerRequest)
        }
}