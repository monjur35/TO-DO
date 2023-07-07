package com.monjur.todoapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    var isDone: Boolean
) {
    constructor(id: Int, isDone: Boolean) : this(id, "", "", isDone)
}
