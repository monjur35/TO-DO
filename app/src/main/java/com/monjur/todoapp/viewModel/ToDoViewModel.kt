package com.monjur.todoapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monjur.todoapp.dao.ToDoDaoImpl
import com.monjur.todoapp.entity.ToDo
import com.monjur.todoapp.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getAllTodo(): MutableLiveData<List<ToDo>> {
        val todoListMutableLiveData = MutableLiveData<List<ToDo>>()
        viewModelScope.launch {
            todoListMutableLiveData.postValue(repository.getAllTodo())
        }
        return todoListMutableLiveData
    }

    fun insertTodo(toDo: ToDo) {
        viewModelScope.launch {
            repository.insertTodo(toDo)
        }
    }

    fun isDone(toDo: ToDo) {
        viewModelScope.launch {
            repository.updateTodo(toDo)
        }
    }


}