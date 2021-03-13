package com.example.guardianapi.callsService
import com.example.guardianapi.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    var httpClient = OkHttpClient.Builder()
    var client: OkHttpClient = httpClient.build()

    val instance: Calls = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()
        .create(Calls::class.java)


}