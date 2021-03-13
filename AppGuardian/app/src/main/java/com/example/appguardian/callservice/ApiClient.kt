package com.example.appguardian.callservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val API_KEY = "5a3ab8d2-0dda-47fa-9604-8c9d54d6a3bf"
    private const val BASE_URL = "https://content.guardianapis.com/"


    var instance = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiCalls::class.java)

}