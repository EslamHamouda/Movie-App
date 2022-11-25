package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(private val services: ServicesAPI) {

    suspend fun getMovieName(para:String) =
        withContext(Dispatchers.IO) {
            services.getMovieName(para)
        }
}