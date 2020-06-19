package com.example.room_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.room_1.database.entity.Task
import com.example.room_1.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.setContext(this)
        viewModel.getLiveData().observe(this, Observer {
            Log.e("MainActivity", "list size: " + it!!.size)

        })
        fetchAllTasks()
    }

    fun addTask(task: Task) {
        viewModel.addTask(task)
    }

    fun updateTask(task: Task) {
        viewModel.updateTask(task)
    }

    fun deleteTask(task: Task) {
        viewModel.deleteTask(task)
    }

    fun fetchAllTasks() {
        return viewModel.fetchAllTasks()
    }

    fun getMainActivityViewModel(): MainActivityViewModel {
        return viewModel
    }

}
