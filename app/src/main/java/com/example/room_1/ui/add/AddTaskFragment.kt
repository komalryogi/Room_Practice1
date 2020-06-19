package com.example.room_1.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.room_1.MainActivity
import com.example.room_1.R
import com.example.room_1.database.entity.Task
import com.example.room_1.ui.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_add_task.*

class AddTaskFragment : Fragment() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        mainActivityViewModel = mainActivity.getMainActivityViewModel()
        mainActivityViewModel =
            ViewModelProviders.of(mainActivity).get(MainActivityViewModel::class.java)

        button_save.setOnClickListener {
            val name = editName.getText().trim().toString()
            val desc = editTextDesc.getText().trim().toString()
            val finishBy = editTextFinishBy.getText().trim().toString()
            val isFinished = true
            var task = Task()
            task.name=name
            task.desc=desc
            task.finishBy=finishBy
            task.finished=false
            mainActivity.addTask(task)
            Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
            requireActivity()!!.onBackPressed()
        }
    }
}
