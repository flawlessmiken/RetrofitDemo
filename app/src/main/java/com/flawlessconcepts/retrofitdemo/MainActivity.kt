package com.flawlessconcepts.retrofitdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.flawlessconcepts.retrofitdemo.albums.BookingItem
import com.flawlessconcepts.retrofitdemo.albums.CustomerItem
import com.flawlessconcepts.retrofitdemo.albums.LocationMatrix
import com.flawlessconcepts.retrofitdemo.roadlink.RetrofitService
import com.flawlessconcepts.retrofitdemo.roadlink.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), LifecycleOwner {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textview.findViewById<TextView>(R.id.tv_show)

        val client = ServiceGenerator.createService(RetrofitService::class.java)


       // val call: Call<List<AlbumsItem?>?>? = client.getAlbums()



        val call = client.getCustomer("08137112552")
        call.enqueue(object : Callback<CustomerItem?> {
            override fun onResponse(
                call: Call<CustomerItem?>,
                response: Response<CustomerItem?>
            ) {
                val statusCode = response.code()
                Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<CustomerItem?>, t: Throwable) {
                // Log error here since request failed\
                //Toast.makeText(applicationContext, "failed"+ t.message, Toast.LENGTH_LONG).show()
            }
        })

        val LmatrixCall = client.getDistanceMatrix("Enugu-North","Enugu-South")
        LmatrixCall.enqueue(object : Callback<LocationMatrix?> {
            override fun onResponse(
                call: Call<LocationMatrix?>,
                response: Response<LocationMatrix?>
            ) {
                val statusCode = response.code()
                Toast.makeText(applicationContext, response.code().toString() +
                        "/n"+response.body().toString() , Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<LocationMatrix?>, t: Throwable) {
                // Log error here since request failed
                Toast.makeText(applicationContext, "failed"+ t.message, Toast.LENGTH_LONG).show()
            }
        })

        val call2 = client.deleteBooking(10000000)
        call2.enqueue(object : Callback<BookingItem?> {
            override fun onResponse(
                call: Call<BookingItem?>,
                response: Response<BookingItem?>
            ) {
                val statusCode = response.code()
               /* Toast.makeText(applicationContext, response.code().toString() +
                        "/n"+response.body().toString() , Toast.LENGTH_LONG).show()

                */

            }

            override fun onFailure(call: Call<BookingItem?>, t: Throwable) {
                // Log error here since request failed
                Toast.makeText(applicationContext, "failed"+ t.message, Toast.LENGTH_LONG).show()
            }
        })
/*
        val call2: Call<List<AlbumsItem?>?>? = client.getAlbums()
        call2?.enqueue(object : Callback<List<AlbumsItem?>?> {
            override fun onResponse(
                call: Call<List<AlbumsItem?>?>?,
                response: Response<List<AlbumsItem?>?>?
            ) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
               //Toast.makeText(applicationContext, response?.body().toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(
                call: Call<List<AlbumsItem?>?>?,
                t: Throwable?
            ) {
                // the network call was a failure
                // TODO: handle error
            }
        })*/
    }




}
