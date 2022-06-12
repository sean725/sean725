package com.example.mvvm_practice01.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_practice01.model.MovieModel;
import com.example.mvvm_practice01.network.APIService;
import com.example.mvvm_practice01.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movies;

    public MovieListViewModel(){
        movies = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMoviesObserver(){ return movies; }

    public void makeApiCall(){

        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {

            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movies.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movies.postValue(null);
            }
        });
    }
}
