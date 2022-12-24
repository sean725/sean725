package com.ebay.android.moviedb.ui.utils

import android.view.View
import androidx.navigation.findNavController
import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.ui.details.DetailsFragmentDirections

fun showMovieDetails(view: View, movie: Movie) {
    view.findNavController().navigate(DetailsFragmentDirections.actionMovieDetails(movie))
}
