package com.example.movieapp.details.data

import com.example.movieapp.data.remote.ServicesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsRepository(private val services: ServicesAPI) {

    suspend fun rate(mId:Int,uId:Int,rate:Int) =
        withContext(Dispatchers.IO) {
            services.rate(mId, uId, rate)
        }


}