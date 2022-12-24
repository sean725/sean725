package com.ebay.android.moviedb.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.network.MovieDatabaseApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getMostPopularMovies()
    }

    private fun getMostPopularMovies() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = MovieDatabaseApi.retrofitService.mostPopular()
                _movies.value = response.results
            } catch (e: Exception) {
                Log.e(HomeViewModel::class.simpleName, "/mostPopular call failed: ${e.javaClass}", e)
            }
            _isLoading.value = false
        }
    }
}
