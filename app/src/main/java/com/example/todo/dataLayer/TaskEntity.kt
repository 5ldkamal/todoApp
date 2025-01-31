package com.example.todo.dataLayer

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "TaskEntity")
data class Task(
    @PrimaryKey(true)
    val id: Int? = null,
    val title: String? = null,
    var date: Date? = null,

    var isDone: Boolean = false,
    var notes: String? = null
)
