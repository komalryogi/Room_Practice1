package com.example.room_1.ui.home

import androidx.lifecycle.ViewModel
import com.example.room_1.MainActivity
import com.example.room_1.database.entity.Task

class HomeFragmentViewModel : ViewModel() {

    fun getLiveData(mainActivity: MainActivity): MutableList<Task> {
        return mainActivity.fetchAllTasks()
    }

    fun updateUi(){

    }
}