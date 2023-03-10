package com.example.internassignment.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internassignment.Adapter
import com.example.internassignment.R
import com.example.internassignment.utils.AUTHTOKEN
import com.example.internassignment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel
    private lateinit var progressBar: ProgressBar
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        vm = ViewModelProvider(this)[MainViewModel::class.java]
        vm.getResponse(AUTHTOKEN)
        observeLiveData()
    }


    private fun observeLiveData() {
        vm.res.observe(this) {
            adapter.updateResponse(it.definitions)
        }
    }
}