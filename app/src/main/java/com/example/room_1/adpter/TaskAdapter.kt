package com.example.room_1.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room_1.R
import com.example.room_1.database.entity.Task

class TaskAdapter(private var context: Context, private var list: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private lateinit var appClickListener: AppClickListener

    fun setAppClickListener(appClickListener: AppClickListener) {
        this.appClickListener = appClickListener
    }

    class TaskViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var textViewStatus: TextView = item.findViewById(R.id.textViewStatus)
        var textViewTask: TextView = item.findViewById(R.id.textViewTask)
        var textViewDesc: TextView = item.findViewById(R.id.textViewDesc)
        var textViewFinishBy: TextView = item.findViewById(R.id.textViewFinishBy)
        var ll_view: LinearLayout = item.findViewById(R.id.ll_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_tasks, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val model = list.get(position)
        holder.textViewTask.setText(model.name)
        holder.textViewDesc.setText(model.desc)
        holder.textViewFinishBy.setText(model.finishBy)
        if (model.finished) {
            holder.textViewStatus.setText("Completed")
        } else {
            holder.textViewStatus.setText("Not Completed")
        }

        holder.ll_view.setOnClickListener {
            if (appClickListener != null)
                appClickListener.onAppClickListener(position, view = it)
        }
    }

    public interface AppClickListener {
        fun onAppClickListener(position: Int, view: View)
    }
}