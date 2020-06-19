package com.example.room_1.database.dao

import androidx.room.*
import com.example.room_1.database.entity.Task


@Dao
interface TaskDao {

    @Query("SELECT * FROM `task` ")
    fun getAllTasks(): MutableList<Task>

    @Insert
    fun insert(task: Task):Long

    @Update
    fun update(task: Task):Int

    @Delete
    fun delete(task: Task):Int
}