package com.example.room_1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room_1.MainActivity
import com.example.room_1.R
import com.example.room_1.adpter.TaskAdapter
import com.example.room_1.database.entity.Task
import com.example.room_1.ui.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private var list = mutableListOf<Task>()
    private lateinit var adapter: TaskAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()

        val mainActivity = activity as MainActivity
        homeFragmentViewModel =
            ViewModelProviders.of(this).get(HomeFragmentViewModel::class.java)
        homeFragmentViewModel.initData(mainActivity.getMainActivityViewModel().getLiveData())

        homeFragmentViewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            Log.e("home", "list size: " + it.size)
            updateUi(it)
        })

        fab_add.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
    }

    private fun initRv() {
        rv_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = TaskAdapter(requireContext(), list)
        adapter.setAppClickListener(object : TaskAdapter.AppClickListener {
            override fun onAppClickListener(position: Int, view: View) {
                when (view!!.id) {
                    R.id.ll_view -> openUpdateFragment(list.get(position))
                }
            }

        })
        rv_view.adapter = adapter
    }

    private fun openUpdateFragment(task: Task) {
        if (task == null) return
        val bundle = Bundle()
        bundle.putParcelable("task", task)
        findNavController().navigate(R.id.action_homeFragment_to_updateTaskFragment, bundle)
    }

    fun updateUi(it: MutableList<Task>) {

        if (it == null) return
        list.clear()
        list.addAll(it)
        adapter.notifyDataSetChanged()
    }
}
