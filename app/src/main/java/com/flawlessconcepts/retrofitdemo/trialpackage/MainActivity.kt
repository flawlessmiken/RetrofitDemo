package com.flawlessconcepts.retrofitdemo.trialpackage
/*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var retService: AlbumService
    // lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textview.findViewById<TextView>(R.id.tv_show)


        val apiService = RetrofitsApi.retrofitService

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getAlbums()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        //Do something with response e.g show to the UI.
                        Toast.makeText(
                            applicationContext,
                            response.body().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        //  toast("Error: ${response.code()}")
                    }
                } catch (e: Exception) {
                    //toast("Exception ${e.message}")
                } catch (e: Throwable) {
                    //toast("Ooops: Something else went wrong")
                }
                // process response...

            }
        }

        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        //getRequestWithQueryParameters()
        //  tryAgain()
    }


    private fun tryAgain() {


        val service = RetrofitInstance.getRetrofitInstance()
        CoroutineScope(Dispatchers.IO).launch {
            val response = retService.getCustomer("{phone: 08237112552}")
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        //Do something with response e.g show to the UI.
                        Toast.makeText(
                            applicationContext,
                            response.body().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        //  toast("Error: ${response.code()}")
                    }
                } catch (e: Exception) {
                    //toast("Exception ${e.message}")
                } catch (e: Throwable) {
                    //toast("Ooops: Something else went wrong")
                }
            }
        }
    }

    private fun getRequestWithQueryParameters() {
        //val responseLiveData: LiveData<Response<Albums>> = liveData {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getSortedAlbums(3)
            emit(response)
        }
        responseLiveData.observe(this, Observer {

            Toast.makeText(applicationContext, it.body().toString(), Toast.LENGTH_SHORT).show()
            //textview.text= it.body().customerFirstName


            /*val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = " " + "Album Title : ${albumsItem.title}" + "\n" +
                            " " + "Album id : ${albumsItem.id}" + "\n" +
                            " " + "User id : ${albumsItem.userId}" + "\n\n\n"
                   // text_view.append(result)
                }
            }*/
        })
    }
    class GitHubRepo {
        val id = 0
        val name: String? = null

        interface GitHubClient {
            @GET("/users/{user}/repos")
            fun reposForUser(
                @Path("user") user: String?,
                callback: Callback<List<GitHubRepo?>?>?
            )
        }
    }


}


*/
