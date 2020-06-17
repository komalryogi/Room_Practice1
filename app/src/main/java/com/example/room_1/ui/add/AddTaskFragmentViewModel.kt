package com.example.room_1.ui.add

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room_1.database.AppDataBase
import com.example.room_1.database.entity.Task

class AddTaskFragmentViewModel(context: Context) : ViewModel() {

    private var liveData = MutableLiveData<Task>()
    private var dataBase: AppDataBase
    private var context: Context

    init {
        this.context = context
        dataBase = AppDataBase.getInstance(context)
    }

    fun getLiveData(): LiveData<Task> {
        return liveData
    }

    fun addTask(task: Task) {
        Thread {
            dataBase.taskDao().insert(task)
        }.start()
    }
}