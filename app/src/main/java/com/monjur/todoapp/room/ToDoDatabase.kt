package com.monjur.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.monjur.todoapp.dao.ToDoDao
import com.monjur.todoapp.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDatabase :RoomDatabase(){
    abstract fun toDoDao():ToDoDao
}