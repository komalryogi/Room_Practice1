package com.example.room_1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room_1.database.entity.Task

class HomeFragmentViewModel : ViewModel() {

    private lateinit var liveData: LiveData<MutableList<Task>>

    fun getLiveData(): LiveData<MutableList<Task>> {
        return liveData
    }

    fun initData(data: MutableLiveData<MutableList<Task>>) {
        liveData = data
    }


}