package com.example.todo.dataLayer

import android.app.ActivityManager.TaskDescription
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.TimeZone


@Entity(tableName = "TaskEntity")
data class Task(
    @PrimaryKey(true)
    val id: Int? = null,
    var title: String? = null,
    var details: String? = null,
    var date: Date? = null,
    var time: String? = null,
    var isDone: Boolean = false,
)
