package com.ebay.android.moviedb.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ebay.android.moviedb.R
import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.databinding.FragmentSearchBinding
import com.ebay.android.moviedb.ui.adapters.MovieAdapter
import com.ebay.android.moviedb.ui.utils.showMovieDetails

class SearchFragment : Fragment(), SearchView.OnQueryTextListener,
    MovieAdapter.MovieClickListener {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var searchViewModel: SearchViewModel

    private lateinit var searchView: SearchView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        binding.searchViewModel = searchViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView = binding.searchSearchView
        searchView.setOnQueryTextListener(this)

        val movieAdapter = MovieAdapter(this)
        binding.searchRecyclerView.adapter = movieAdapter

        searchViewModel.movies.observe(viewLifecycleOwner, Observer {
            movieAdapter.updateMovies(it)
        })


    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query.takeUnless { it.isNullOrEmpty() }?.let {
            searchViewModel.performSearch(it)
            searchView.clearFocus()

            return true
        }
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean = true

    override fun handleClick(view: View, movie: Movie) {
        showMovieDetails(view, movie)
    }
}
