package com.example.room_1.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.room_1.MainActivity
import com.example.room_1.R
import com.example.room_1.database.entity.Task
import kotlinx.android.synthetic.main.fragment_update_task.*

/**
 * A simple [Fragment] subclass.
 */
class UpdateTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
    }

    private fun setData() {
        if (arguments == null) return
        val task = this.requireArguments().getParcelable<Task>("task")
        if (task == null) return
        editTextTask.setText("" + task.name)
        editTextDesc.setText("" + task.desc)
        editTextFinishBy.setText("" + task.finishBy)

        button_update.setOnClickListener {
            val name = editTextTask.text.trim().toString()
            val desc = editTextDesc.text.trim().toString()
            val finishBy = editTextFinishBy.text.trim().toString()

            task.name = name
            task.desc = desc
            task.finishBy = finishBy

            val mainActivity = activity as MainActivity
            mainActivity.updateTask(task)

            Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
            requireActivity()!!.onBackPressed()
        }
        val mainActivity = activity as MainActivity

        button_update.setOnClickListener {
            val name = editTextTask.text.trim().toString()
            val desc = editTextDesc.text.trim().toString()
            val finishBy = editTextFinishBy.text.trim().toString()

            task.name = name
            task.desc = desc
            task.finishBy = finishBy

            mainActivity.updateTask(task)
            Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
            requireActivity()!!.onBackPressed()
        }

        button_delete.setOnClickListener {

            mainActivity.deleteTask(task)
            Toast.makeText(requireContext(), "deleted", Toast.LENGTH_SHORT).show()
            requireActivity()!!.onBackPressed()
        }
    }

}
