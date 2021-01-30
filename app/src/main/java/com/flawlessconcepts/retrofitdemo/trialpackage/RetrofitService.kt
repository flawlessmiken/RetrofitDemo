package com.flawlessconcepts.retrofitdemo.trialpackage

import com.flawlessconcepts.retrofitdemo.Albums
import com.flawlessconcepts.retrofitdemo.AlbumsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {
    @GET("/albums/{id}")
    fun getAlbumbySorted(
        @Query("id") id: Int?,
        callback: Callback<List<AlbumsItem?>?>?
    )

    @GET("/albums")
    fun getAlbum(@Query("id") id: Int): Call<Albums>

    @GET("/albums")
    fun getAlbums(): Call<List<AlbumsItem?>?>?

    @GET("/tutorials")
    fun getTutorials(
        @Query("albumID") id: Int?
    ): Call<List<AlbumsItem?>?>?

}
interface GitHubClient {

}