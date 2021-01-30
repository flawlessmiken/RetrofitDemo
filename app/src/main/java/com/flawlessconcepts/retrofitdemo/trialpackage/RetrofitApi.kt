/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.flawlessconcepts.retrofitdemo.trialpackage

import com.flawlessconcepts.retrofitdemo.AlbumsItem
import com.flawlessconcepts.retrofitdemo.MainActivity
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

val BASE_URL: String = "https://jsonplaceholder.typicode.com"

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(GsonConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()


var API_BASE_URL ="https://jsonplaceholder.typicode.com"

var httpClient = OkHttpClient.Builder()

var builder = Retrofit.Builder()
    .baseUrl(API_BASE_URL)
    .addConverterFactory(
        GsonConverterFactory.create()
    )

var retrofit = builder.client(
        httpClient.build()
    ).build()

var client = retrofit.create(RetrofitService::class.java)



/*
interface RetrofitServicee {
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>


    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId: Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId: Int): Response<AlbumsItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem): Response<AlbumsItem>


}
*/

//
//object RetrofitsApi {
//    val retrofitService: RetrofitService by lazy {
//        retrofit.create(RetrofitService::class.java)
//    }
//}



