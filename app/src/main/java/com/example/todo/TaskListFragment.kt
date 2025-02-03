package com.example.todo

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.todo.Adapter.DayViewContainer
import com.example.todo.databinding.CalendarDayItemBinding
import com.example.todo.databinding.FragmentAddingTaskBinding
import com.example.todo.databinding.FragmentTaskListBinding
import com.kizitonwose.calendar.core.WeekDay
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.view.WeekDayBinder
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

final class TaskListFragment : Fragment() {
    lateinit var viewBinding: FragmentTaskListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTaskListBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setupCalendarView()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setupCalendarView() {
        val currentDate = LocalDate.now()
        val currentMonth = YearMonth.now()
        val startDate = LocalDate.now() // Adjust as needed
        val endDate = currentMonth.plusMonths(100).atEndOfMonth() // Adjust as needed
        val firstDayOfWeek = firstDayOfWeekFromLocale() // Available from the library
        viewBinding.caledarView.setup(startDate, endDate, firstDayOfWeek)
        viewBinding.caledarView.scrollToWeek(currentDate)


        viewBinding.caledarView.dayBinder = object : WeekDayBinder<DayViewContainer> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun bind(container: DayViewContainer, data: WeekDay) {
                container.dayName.text =
                    data.date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                container.dayNumber.text = data.date.dayOfMonth.toString()
            }

            override fun create(view: View): DayViewContainer {
                return DayViewContainer(view)
            }

        }
    }
}