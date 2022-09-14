package com.example.movieapp.home.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActorModel(@SerializedName("actorId"        ) var actorId        : Int?    = null,
                      @SerializedName("actorName"      ) var actorName      : String? = null,
                      @SerializedName("actorImagePath" ) var actorImagePath : String? = null):Parcelable
