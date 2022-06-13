package com.example.seanlee_takehomeproject.model.api;

import com.example.seanlee_takehomeproject.model.objects.BusinessesModel;
import com.example.seanlee_takehomeproject.model.objects.ReviewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    // get businesses
    @GET("businesses/search")
    Call<BusinessesModel> getBusinesses(@Header ("Authorization") String _authHeader, @Query("location") String _cityName, @Query("limit") int _limit);

    // get reviews
    @GET("businesses/{id}/reviews")
    Call<ReviewsModel> getReviews(@Header("Authorization") String _authHeader, @Path("id") String _id);
}
