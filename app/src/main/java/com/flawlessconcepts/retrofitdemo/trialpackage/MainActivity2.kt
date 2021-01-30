package com.flawlessconcepts.retrofitdemo.trialpackage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.flawlessconcepts.retrofitdemo.Albums
import com.flawlessconcepts.retrofitdemo.AlbumsItem
import com.flawlessconcepts.retrofitdemo.R
import com.flawlessconcepts.retrofitdemo.trialpackage.RetrofitService
import com.flawlessconcepts.retrofitdemo.trialpackage.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity2 : AppCompatActivity(), LifecycleOwner {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textview.findViewById<TextView>(R.id.tv_show)

        val client = ServiceGenerator.createService(RetrofitService::class.java)


       // val call: Call<List<AlbumsItem?>?>? = client.getAlbums()



        val call = client.getAlbum(3)
        call.enqueue(object : Callback<Albums?> {
            override fun onResponse(
                call: Call<Albums?>,
                response: Response<Albums?>
            ) {
                val statusCode = response.code()
                Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<Albums?>, t: Throwable) {
                // Log error here since request failed\
                Toast.makeText(applicationContext, "failed"+ t.message, Toast.LENGTH_LONG).show()
            }
        })

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
        })
    }




}
