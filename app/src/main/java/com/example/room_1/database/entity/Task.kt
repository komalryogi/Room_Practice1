package com.example.room_1.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "task")
    var name: String,
    @ColumnInfo(name = "desc")
    var desc: String,
    @ColumnInfo(name = "finishBy")
    var finishBy: String,
    @ColumnInfo(name = "finished")
    var finished: Boolean
) : Parcelable {

   constructor() : this(0, "", "", "",false)
}