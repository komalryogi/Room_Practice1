package com.example.room_1.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room_1.database.AppDataBase
import com.example.room_1.database.entity.Task

class MainActivityViewModel(context: Context) : ViewModel() {

    private var liveData = MutableLiveData<MutableList<Task>>()
    private var dataBase: AppDataBase
    private var context: Context

    init {
        this.context = context
        dataBase = AppDataBase.getInstance(context)
    }

    fun getLiveData(): LiveData<MutableList<Task>> {
        return liveData
    }

    fun addTask(task: Task) {
        Thread {
            dataBase.taskDao().insert(task)
        }.start()
    }

    fun updateTask(task: Task) {
        Thread {
            dataBase.taskDao().update(task)
        }.start()
    }

    fun deleteTask(task: Task) {
        Thread {
            dataBase.taskDao().delete(task)
        }.start()
    }

    fun updateData(old_task: Task, new_task: Task) {
        val value = liveData.value
        val indexOf = value!!.indexOf(old_task)
        value.set(indexOf, new_task)
        liveData.value = value
    }

    fun referesh() {
        fetchAllTasks()
    }

    fun fetchAllTasks(): MutableList<Task> {
        val allTasks = null
        Thread {
            dataBase.taskDao().getAllTasks()
            liveData.postValue(allTasks)
        }.start()
        return allTasks!!
    }
}