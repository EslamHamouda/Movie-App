package com.example.movieapp.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    val title: String,
    val imageURL: String,
    val genre: String,
    val year: Int,
    val duration: Int
):Parcelable
