package com.example.todo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setupFAB()
    }

    private fun  setupBottomNavView() {
        viewBinding.bottomNavigationView.setOnItemSelectedListener {
            when (it) {
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun  setupFAB() {
        viewBinding.fabAddTask.setOnClickListener{
            openAddTask()
        }
    }

    private fun openAddTask() {
        val addingTaskFragment = AddingTaskFragment()
        addingTaskFragment.show(supportFragmentManager , null)
    }
}