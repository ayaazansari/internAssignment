package com.example.internassignment.api

import com.example.internassignment.models.response
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface API {
    @GET("dictionary/bar")
    suspend fun definition(
        @Header("Authorization") token: String
    ): Response<response>


}