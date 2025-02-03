package com.example.todo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.todo.dataLayer.Task
import com.example.todo.databinding.TaskItemBinding

final class TaskListAdapter : Adapter<TaskListAdapter.TaskItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val viewBinding = TaskItemBinding.inflate(infalter)
        return TaskItemViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class TaskItemViewHolder(val viewBinding: ViewBinding) : ViewHolder(viewBinding.root) {
        fun bind(task: Task) {
        }
    }


}