package com.example.todo

import android.app.Application
import com.example.todo.dataLayer.DataBaseManager

class TaskApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DataBaseManager.init(this)
    }
}