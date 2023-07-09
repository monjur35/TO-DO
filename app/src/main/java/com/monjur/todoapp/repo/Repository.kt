package com.monjur.todoapp.repo

import com.monjur.todoapp.dao.ToDoDaoImpl
import com.monjur.todoapp.entity.ToDo
import javax.inject.Inject

class Repository @Inject constructor(private val toDoDaoImpl: ToDoDaoImpl) {

    suspend fun getAllTodo()=toDoDaoImpl.getAllToDo()
    suspend fun insertTodo(toDo: ToDo)=toDoDaoImpl.insertToDo(toDo)
    suspend fun updateTodo(toDo: ToDo)=toDoDaoImpl.isDone(toDo)
}