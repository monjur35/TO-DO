package com.monjur.todoapp.dao

import com.monjur.todoapp.entity.ToDo
import javax.inject.Inject

class ToDoDaoImpl @Inject constructor(private val todoDao: ToDoDao) : ToDoDao {
    override suspend fun getAllToDo(): List<ToDo> {
        return todoDao.getAllToDo()
    }

    override suspend fun insertToDo(toDo: ToDo) {
        todoDao.insertToDo(toDo)
    }

    override suspend fun isDone(toDo: ToDo) {
        todoDao.isDone(toDo)
    }
}