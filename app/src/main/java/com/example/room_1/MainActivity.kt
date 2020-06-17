package com.example.room_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.room_1.database.entity.Task
import com.example.room_1.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private var list = mutableListOf<Task>()
  //  private lateinit var adapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.getLiveData().observe(this, Observer {
            list.clear()
            list.addAll(it)
         //   adapter.notifyDataSetChanged()
        })

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

    fun updateData(old_task: Task, new_task: Task) {
        viewModel.updateData(old_task, new_task)
    }

    fun referesh() {
        viewModel.referesh()
    }

    fun fetchAllTasks(): MutableList<Task> {
        return viewModel.fetchAllTasks()
    }

}
