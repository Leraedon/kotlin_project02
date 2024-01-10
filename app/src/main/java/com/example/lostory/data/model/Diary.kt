package com.example.lostory.data.model

data class Diary(
    val uid: String,
    val date: Int,
    val diary: String? = null,
    val imageList: List<String>? = null
)
