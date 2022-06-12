package com.example.mvvm_practice01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvvm_practice01.adapter.MovieListAdapter;
import com.example.mvvm_practice01.model.MovieModel;
import com.example.mvvm_practice01.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MovieModel> mMovieModelList;
    private MovieListAdapter mAdapter;
    private MovieListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nrf = findViewById(R.id.nrf);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MovieListAdapter(this, mMovieModelList);
        recyclerView.setAdapter(mAdapter);

        mViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        mViewModel.getMoviesObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    mMovieModelList = movieModels;
                    mAdapter.setCollection(movieModels);
                    nrf.setVisibility(View.GONE);
                }else{
                    nrf.setVisibility(View.VISIBLE);
                }
            }
        });
        mViewModel.makeApiCall();
    }
}