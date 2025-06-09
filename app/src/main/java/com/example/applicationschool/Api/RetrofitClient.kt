package com.example.applicationschool.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //  // Adresa bazë e API-së Për emulator Android
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val client = OkHttpClient.Builder() // Krijimi i një klienti HTTP të thjeshtë
        .build()
    // Krijimi i një instance të ApiService duke përdorur Retrofit
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)// vendos URL-në bazë të serverit
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)//krijon implementim e api service

    }
}
