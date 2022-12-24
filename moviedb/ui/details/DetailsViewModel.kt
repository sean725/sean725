package com.ebay.android.moviedb.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ebay.android.moviedb.data.Movie

class DetailsViewModel(movie: Movie) : ViewModel() {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _overview = MutableLiveData<String>()
    val overview: LiveData<String>
        get() = _overview

    private val _posterPath = MutableLiveData<String>()
    val posterPath: LiveData<String>
        get() = _posterPath

    init {
        _title.value = movie.title
        _overview.value = movie.overview
        _posterPath.value = movie.posterPath
    }
}
