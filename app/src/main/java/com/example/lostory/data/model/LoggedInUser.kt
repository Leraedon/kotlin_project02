package com.example.lostory.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val uid: String,
    val name: String?,
    val email: String?,
    val motto: String? = null
)