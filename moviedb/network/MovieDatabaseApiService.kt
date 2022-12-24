package com.ebay.android.moviedb.network

import com.ebay.android.moviedb.data.Movie
import com.ebay.android.moviedb.data.MovieDatabaseResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "789a3ad9fb130b33628be0e27eaf57c8"



/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface MovieDatabaseApiService {
    /**
     * Returns a Coroutine [List] of [Movie] which can be fetched with await() if
     * in a Coroutine scope.
     * The @GET annotation indicates that the "mostPopular" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("discover/movie?api_key=$API_KEY&sort_by=popularity.desc")
    suspend fun mostPopular(): MovieDatabaseResponse

    /**
     * Returns a Coroutine [List] of [Movie] based on a query which can be fetched with await() if
     * in a Coroutine scope.
     * The @GET annotation indicates that the "search" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("search/movie?api_key=$API_KEY")
    suspend fun search(@Query("query") query: String): MovieDatabaseResponse
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MovieDatabaseApi {
    val retrofitService : MovieDatabaseApiService by lazy { retrofit.create(MovieDatabaseApiService::class.java) }
}
