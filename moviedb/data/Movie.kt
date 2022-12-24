package com.ebay.android.moviedb.data

import java.io.Serializable

data class Movie(
    val title: String,
    val posterPath: String?,
    val overview: String?
) : Serializable