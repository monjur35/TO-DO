package com.monjur.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.monjur.todoapp.R
import com.monjur.todoapp.databinding.FragmentAddToDoBinding
import com.monjur.todoapp.entity.ToDo
import com.monjur.todoapp.viewModel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToDoFragment : Fragment() {
    private lateinit var binding: FragmentAddToDoBinding
    private val toDoViewModel: ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddToDoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitButton.setOnClickListener {
            val title = binding.titleET.text.toString()
            val description = binding.descriptionET.text.toString()

            if (title.isEmpty()) {
                Toast.makeText(requireContext(), "Please,Enter Title", Toast.LENGTH_SHORT).show()
            } else {
                toDoViewModel.insertTodo(ToDo(0, title, description, false))
                Navigation.findNavController(it)
                    .navigate(R.id.action_addToDoFragment_to_homeFragment)
            }

        }

    }


}