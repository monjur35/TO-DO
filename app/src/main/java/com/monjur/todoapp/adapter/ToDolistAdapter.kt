package com.monjur.todoapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.monjur.todoapp.R
import com.monjur.todoapp.databinding.ItemRowBinding
import com.monjur.todoapp.entity.ToDo
import com.monjur.todoapp.fragment.HomeFragment

class ToDolistAdapter(val list: List<ToDo>, val homeFragment: HomeFragment) :
    RecyclerView.Adapter<ToDolistAdapter.ToDoListViewHolder>() {

    inner class ToDoListViewHolder(private val binding: ItemRowBinding) : ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(item: ToDo) {
            binding.title.text = item.title

            binding.checkbox.isChecked = item.isDone

            binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
                item.isDone = isChecked
                homeFragment.checkClicked(item)

                if (isChecked) {
                    binding.title.paintFlags =
                        binding.title.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    binding.title.setTextColor(Color.GRAY)
                } else{
                    binding.title.paintFlags = 0
                    binding.title.setTextColor(Color.DKGRAY)
                }
            }

            if (item.isDone) {
                binding.title.paintFlags = binding.title.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.title.setTextColor(Color.GRAY)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val view = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface CheckBoxClick {
        fun checkClicked(toDo: ToDo)
    }
}