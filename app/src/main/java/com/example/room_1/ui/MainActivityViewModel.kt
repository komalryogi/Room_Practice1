package com.example.room_1.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room_1.database.AppDataBase
import com.example.room_1.database.entity.Task

class MainActivityViewModel : ViewModel() {

    private var liveData = MutableLiveData<MutableList<Task>>()
    private lateinit var dataBase: AppDataBase
    private lateinit var context: Context


    fun setContext(context: Context) {
        this.context = context
        dataBase = AppDataBase.getInstance(context)

    }

    fun getLiveData(): MutableLiveData<MutableList<Task>> {
        return liveData
    }

    fun addTask(task: Task) {

        Thread {
            val insert = dataBase.taskDao().insert(task)
            Log.e("MAIN_VM", "insert: $insert")

        }.start()
    }

    fun updateTask(task: Task) {
        Thread {
            val update = dataBase.taskDao().update(task)
            Log.e("MAIN_VM", "update: $ update" )
        }.start()
    }

    fun deleteTask(task: Task) {
        Thread {
            val delete = dataBase.taskDao().delete(task)
            Log.e("MAIN_VM", "delete: $delete")

        }.start()
    }

    fun fetchAllTasks() {
        val allTasks = mutableListOf<Task>()
        Thread {
            val value = dataBase.taskDao().getAllTasks()
            liveData.postValue(value)
        }.start()

    }
}