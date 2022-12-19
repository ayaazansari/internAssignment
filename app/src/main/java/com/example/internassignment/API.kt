package com.example.internassignment

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface API {
    @GET("dictionary/bar")
    suspend fun definition(
                           @Header("Authorization") token: String
    ): Response<response>


}