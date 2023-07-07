package com.monjur.todoapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.monjur.todoapp.entity.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo ORDER BY CASE WHEN isDone = 0 THEN 0 ELSE 1 END")
    suspend fun getAllToDo(): List<ToDo>

    @Insert
    suspend fun insertToDo(toDo: ToDo)

    @Update
    suspend fun isDone(toDo: ToDo)
}