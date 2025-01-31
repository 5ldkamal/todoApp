package com.example.todo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    private fun  setupBottomNavView() {
        viewBinding.bottomNavigationView.setOnItemSelectedListener {
            when (it) {
R.id.
            }
            return@setOnItemSelectedListener true
        }
    }
}