package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRepository @Inject constructor(private val services: ServicesAPI) {

    suspend fun rate(mId:Int,uId:Int,rate:Int) =
        withContext(Dispatchers.IO) {
            services.rate(mId, uId, rate)
        }


}