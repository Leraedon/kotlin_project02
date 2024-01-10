package com.example.lostory.data.model

data class Objective(
    val uid: String,
    val objId: Int,
    val title: String? = null,
    val currentPoint: Double? = null,
    val goalPoint: Double? = null,
    val unit: String? = null
)
