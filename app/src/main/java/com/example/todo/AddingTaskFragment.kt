package com.example.todo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.compose.material3.TimePicker
import androidx.room.Database
import com.example.todo.dataLayer.DataBaseManager
import com.example.todo.dataLayer.Task
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.databinding.FragmentAddingTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

final class AddingTaskFragment : BottomSheetDialogFragment() {
    lateinit var viewBinding: FragmentAddingTaskBinding

    private val calendar = Calendar.getInstance() // Get instance of Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAddingTaskBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.dateEditText.setOnClickListener({
            showDatePicker()
        })

        viewBinding.fabAddTask.setOnClickListener({
            addTask()
            dismiss()
        })
    }

    fun addTask() {
        var task = Task()
        task.title = viewBinding.enterTaskEditText.text.toString()
        task.details = viewBinding.enterTaskEditText.text.toString()
        task.date = calendar.time

        DataBaseManager.getInstance().getTaskDAO().insert(task)
    }


    private fun showDatePicker() {
        val picker = DatePickerDialog(
            requireActivity(),
            { view, year, month, day ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)
                viewBinding.dateEditText.text = "${day}/${month + 1}/${year}"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        picker.show()
    }


}