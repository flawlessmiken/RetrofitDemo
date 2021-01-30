package com.flawlessconcepts.retrofitdemo.roadlink

import com.flawlessconcepts.retrofitdemo.AlbumsItem
import com.flawlessconcepts.retrofitdemo.albums.BookingItem
import com.flawlessconcepts.retrofitdemo.albums.CustomerItem
import com.flawlessconcepts.retrofitdemo.albums.LocationMatrix
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query


//https://www.road-link.biz/webresources/rest/getCustomerService.
interface RetrofitService {
    @GET("/albums/{id}")
    fun getAlbumbySorted(
        @Query("id") id: Int?,
        callback: Callback<List<AlbumsItem?>?>?
    )

    @GET("/webresources/rest/getCustomerService")
    fun getCustomer(@Query("phone") phone: String): Call<CustomerItem>

    @GET("/webresources/rest/viewBookingService")
    fun getBooking(@Query("bookingID") bookingID: Long): Call<BookingItem>


    @PUT("/webresources/rest/removeBookingService")
    fun deleteBooking(@Query("bknID") bookingID: Long): Call<BookingItem>


    @GET("/webresources/rest/getDistanceMatrixService")
    fun getDistanceMatrix(
        @Query("fromLocation") fromLocation: String?,
        @Query("toLocation") toLocation: String?
    ): Call<LocationMatrix>



    @GET("/albums")
    fun getAlbums(): Call<List<AlbumsItem?>?>?

    @GET("/tutorials")
    fun getTutorials(
        @Query("albumID") id: Int?
    ): Call<List<AlbumsItem?>?>?

}
interface GitHubClient {

}