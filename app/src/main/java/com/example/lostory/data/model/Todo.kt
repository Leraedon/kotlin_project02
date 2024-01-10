package com.example.lostory.data.model

data class Todo(
    val uid: String,
    val todoId: Int,
    val title: String? = null,
    val priority: Int? = null,
    val isCompleted: Int? = null,
    val date: String? = null
)
