package com.example.room_1.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room_1.R
import com.example.room_1.database.entity.Task

class TaskAdapter(context: Context, list: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    var context: Context
    var list: MutableList<Task>

    init {
        this.context = context
        this.list = list
    }

    class TaskViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var  textViewStatus: TextView
        var  textViewTask: TextView
        var  textViewDesc: TextView
        var  textViewFinishBy: TextView

        init {
            textViewStatus=item.findViewById(R.id.textViewStatus)
            textViewTask=item.findViewById(R.id.textViewTask)
            textViewDesc=item.findViewById(R.id.textViewDesc)
            textViewFinishBy=item.findViewById(R.id.textViewFinishBy)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
       var view= LayoutInflater.from(context).inflate(R.layout.recyclerview_tasks, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (list == null) return 0
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val model = list.get(position)
        holder.textViewTask.setText(model.name)
        holder.textViewDesc.setText(model.desc)
        holder.textViewFinishBy.setText(model.finishBy)
        if (model.finished){
            holder.textViewStatus.setText("Completed")
        }else{
            holder.textViewStatus.setText("Not Completed")
        }
    }
}