package com.ebay.android.moviedb.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"

@BindingAdapter("posterPath")
fun loadMoviePoster(view: ImageView, posterPath: String?) {
    posterPath
        .takeUnless { it.isNullOrEmpty() }
        .let { Picasso.get().load(BASE_IMAGE_URL + it).into(view) }
}
