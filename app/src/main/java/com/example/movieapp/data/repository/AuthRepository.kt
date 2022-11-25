package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.ServicesAPI
import com.example.movieapp.data.models.request.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(val services: ServicesAPI) {

    suspend fun login(map:Map<String,String>) =
        withContext(Dispatchers.IO) {
            services.login(map)
        }
    suspend fun register(registerRequest: RegisterRequest) =
        withContext(Dispatchers.IO) {
            services.register(registerRequest)
        }
}