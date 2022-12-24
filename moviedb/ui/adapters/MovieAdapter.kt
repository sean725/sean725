package com.ebay.android.moviedb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ebay.android.moviedb.BR
import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.databinding.ItemMovieBinding

class MovieAdapter(private val movieClickListener: MovieClickListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemMovieBinding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(movies[position], movieClickListener)

    fun updateMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    // first see poster has a data
    // check if its valid url
    // why no data

    class MovieViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, movieClickListener: MovieClickListener) {
            binding.setVariable(BR.movie, movie)
            binding.setVariable(BR.clickHandler, movieClickListener)
            binding.executePendingBindings()
        }
    }

    interface MovieClickListener {
        fun handleClick(view: View, movie: Movie)
    }
}
