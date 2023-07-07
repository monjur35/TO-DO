package com.monjur.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.monjur.todoapp.R
import com.monjur.todoapp.adapter.ToDolistAdapter
import com.monjur.todoapp.databinding.FragmentHomeBinding
import com.monjur.todoapp.entity.ToDo
import com.monjur.todoapp.viewModel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), ToDolistAdapter.CheckBoxClick {
    private lateinit var binding: FragmentHomeBinding
    private val toDoViewModel: ToDoViewModel by viewModels()
    private lateinit var toDolistAdapter: ToDolistAdapter

    private val todoList = mutableListOf<ToDo>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        toDolistAdapter = ToDolistAdapter(todoList, this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listRv.apply {
            adapter = toDolistAdapter
        }
        toDoViewModel.getAllTodo().observe(this) {
            if (it.isNotEmpty()) {
                todoList.clear()
                todoList.addAll(it)
                toDolistAdapter.notifyDataSetChanged()
            }
        }

        binding.addTodoFab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addToDoFragment)
        }
    }

    override fun checkClicked(toDo: ToDo) {
        toDoViewModel.isDone(toDo)
    }
}