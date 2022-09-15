package com.example.movieapp.home.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesModel(@SerializedName("movieId"      ) var movieId      : Int?    = null,
                       @SerializedName("movieName"    ) var movieName    : String? = null,
                       @SerializedName("age"          ) var age          : String? = null,
                       @SerializedName("directorName" ) var directorName : String? = null,
                       @SerializedName("category"     ) var category     : String? = null,
                       @SerializedName("image"        ) var image        : String? = null,
                       @SerializedName("video"        ) var video        : String? = null,
                       @SerializedName("description"  ) var description  : String? = null,
                       @SerializedName("releasedYear" ) var releasedYear : Int?    = null,
                       @SerializedName("addedDate"    ) var addedDate    : String? = null,
                       @SerializedName("time"         ) var time         : Int?    = null):Parcelable
