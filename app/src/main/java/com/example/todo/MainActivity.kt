package com.example.todo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.todo.dataLayer.DataBaseManager
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setupFAB()
        setupBottomNavView()
    }

    private fun setupBottomNavView() {
        viewBinding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_item_tasks_list -> {
                    openFragment(TaskListFragment())
                }

                R.id.nav_item_settings -> {
                    //openFragment(TaskListFragment())
                }
            }
            return@setOnItemSelectedListener true
        }

        viewBinding.bottomNavigationView.selectedItemId = R.id.nav_item_tasks_list
    }

    private fun setupFAB() {
        viewBinding.fabAddTask.setOnClickListener {
            openAddTask()
        }
    }

    private fun openAddTask() {
        val addingTaskFragment = AddingTaskFragment()
        addingTaskFragment.show(supportFragmentManager, null)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameLayout.id, fragment)
            .commit()
    }
}