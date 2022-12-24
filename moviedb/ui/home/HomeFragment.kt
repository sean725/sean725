package com.ebay.android.moviedb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ebay.android.moviedb.R
import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.databinding.FragmentHomeBinding
import com.ebay.android.moviedb.ui.adapters.MovieAdapter
import com.ebay.android.moviedb.ui.utils.showMovieDetails

class HomeFragment : Fragment(), MovieAdapter.MovieClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.homeViewModel = homeViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieAdapter = MovieAdapter(this)
        binding.homeRecyclerView.adapter = movieAdapter

        homeViewModel.movies.observe(viewLifecycleOwner, Observer {
            movieAdapter.updateMovies(it)
        })
    }

    override fun handleClick(view: View, movie: Movie) {
        showMovieDetails(view, movie)
    }
}
