package com.example.seanlee_takehomeproject.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static final String BASE_URL = "https://api.yelp.com/v3/";
    // TODO: should this be a private variable?
    public static final String API_KEY = "dj_FOzmZCkNvIGoTBgCH4h__OTwl5tND4-Bgyu9ow3vnrcQNWA4UwklUCcG82wbJkrxToFf8d-8MZSosRsoJmrjAgb6ZBJr0SrtZqL360d4gv7CIbpBt-NvUmu6jYnYx";

    private static Retrofit mRetrofit;

    public static Retrofit getRetroClient(){

        // singleton
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static String apiKeyBuilder(){
        return "Bearer " + API_KEY;
    }
}
