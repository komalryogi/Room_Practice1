package com.example.room_1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room_1.MainActivity
import com.example.room_1.R
import com.example.room_1.adpter.TaskAdapter
import com.example.room_1.database.entity.Task
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private var list = mutableListOf<Task>()
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }

    fun updateUi(it: MutableList<Task>) {
        list.clear()
        list.addAll(it)
        adapter.notifyDataSetChanged()
    }

    fun initRv() {
        rv_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_view.adapter = TaskAdapter(requireContext(), list)
        val mainActivity = activity as MainActivity
        mainActivity.fetchAllTasks()
    }
}
