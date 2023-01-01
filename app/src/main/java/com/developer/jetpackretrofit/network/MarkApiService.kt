package com.developer.jetpackretrofit.network

import com.developer.jetpackretrofit.`object`.Student
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.text.DateFormat


private const val BASE_URL =
    "http://192.168.1.2:3000/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos")
    suspend fun getPhoto(): Student
}

object MarkApi {
    val retrofitService: MarsApiService =
        retrofit.create(MarsApiService::class.java)
}