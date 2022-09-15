package com.example.movieapp.search.data

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRepository(private val services: ServicesAPI) {

    suspend fun getMovieName(para:String) =
        withContext(Dispatchers.IO) {
            services.getMovieName(para)
        }
}