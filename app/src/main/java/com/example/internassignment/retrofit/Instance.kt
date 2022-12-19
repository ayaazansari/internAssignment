package com.example.internassignment.retrofit

import com.example.internassignment.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object instance {
    val api: API by lazy{
        Retrofit.Builder()
            .baseUrl("https://owlbot.info/api/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}