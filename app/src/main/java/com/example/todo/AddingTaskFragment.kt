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
import java.util.Calendar

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
        viewBinding.fabAddTask.setOnClickListener({
        })
    }

}