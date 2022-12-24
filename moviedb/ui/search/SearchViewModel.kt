package com.ebay.android.moviedb.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.network.MovieDatabaseApi
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun performSearch(query: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = MovieDatabaseApi.retrofitService.search(query)
                _movies.value = response.results

            } catch (e: Exception) {
                Log.e(SearchViewModel::class.simpleName, "/search call failed: ${e.javaClass}", e)
            }
            //
            finally {
                _isLoading.value = false
            }
        }
    }
}
