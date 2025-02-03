package com.example.todo.Adapter

import android.view.View
import com.example.todo.databinding.CalendarDayItemBinding
import com.kizitonwose.calendar.view.ViewContainer

class DayViewContainer(view: View) : ViewContainer(view) {
    val dayNumber = CalendarDayItemBinding.bind(view).dayNumber
    val dayName = CalendarDayItemBinding.bind(view).dayName
}