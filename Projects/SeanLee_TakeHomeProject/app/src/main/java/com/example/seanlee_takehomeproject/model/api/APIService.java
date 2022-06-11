package com.example.seanlee_takehomeproject.model.api;

import com.example.seanlee_takehomeproject.model.objects.BusinessModel;
import com.example.seanlee_takehomeproject.model.objects.BusinessesModel;
import com.example.seanlee_takehomeproject.model.objects.ReviewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {

    // get businesses
    @GET("businesses/search")
    Call<BusinessesModel> getBusinesses(@Header ("Authorization") String _authHeader, @Query("location") String _cityName, @Query("limit") int _limit);

//    // get business detail
//    @GET("statement_here.json")
//    Call<BusinessModel> getBusinessDetail(@Header ("Authorization") String _authHeader, @Query("locale") String _id);

    // get reviews
//    @GET("businesses/{id}/reviews")
//    Call<ReviewsModel> getReviews(@Url("id") String _id, @Header ("Authorization") String _authHeader);

    @GET("businesses/{id}/reviews")
    Call<ReviewsModel> getReviews(@Header("Authorization") String _authHeader, @Path("id") String _id);
//
//    static String reviewUrlBuilder(String _id){
//        return "businesses/" + _id + "/reviews";
//    }
}
