package com.example.mvvm_practice01.network;

import com.example.mvvm_practice01.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("volley_array.json")
    Call<List<MovieModel>> getMovieList();
}
