package com.flawlessconcepts.retrofitdemo

import com.flawlessconcepts.retrofitdemo.albums.CustomerItem
import retrofit2.Response
import retrofit2.http.*


interface AlbumService {

   // https://www.road-link.biz/webresources/rest/getCustomerService.

    @GET("/webresources/rest/getCustomerService.")
    suspend fun getCustomer(@Path(value ="phone")phone: String): Response<String>

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    @FormUrlEncoded
    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId: Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId: Int): Response<AlbumsItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem): Response<AlbumsItem>


}