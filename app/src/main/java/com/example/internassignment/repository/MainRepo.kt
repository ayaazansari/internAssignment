package com.example.internassignment.repository

import android.util.Log
import com.example.internassignment.models.response
import com.example.internassignment.retrofit.instance
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


class MainRepo {

    suspend fun getResponse(token: String): Response<response>? {
        val response = try {
            instance.api.definition(token)
        } catch (e: IOException) {
            Log.e("network", "IOException, you might not have internet connection $e")
            null
        } catch (e: HttpException) {
            Log.e("network", e.toString())
            null
        }
        return response
    }

}
