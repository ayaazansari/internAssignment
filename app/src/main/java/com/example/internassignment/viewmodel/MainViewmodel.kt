package com.example.internassignment.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.internassignment.repository.MainRepo
import com.example.internassignment.models.response
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    var repo: MainRepo? = null
    var status = MutableLiveData<Boolean>()
    var res = MutableLiveData<response>()

    init {
        repo = MainRepo()
    }

    fun getResponse( token: String) {
        viewModelScope.launch {
            val response = repo!!.getResponse( token)
            Log.e("response", response.toString())
            if (response?.isSuccessful == true) {
                status.postValue(true)
                res.postValue(response.body())
            } else
                status.postValue(false)
        }
    }

}