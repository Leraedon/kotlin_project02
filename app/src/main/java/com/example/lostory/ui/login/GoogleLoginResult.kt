package com.example.lostory.ui.login

sealed class GoogleLoginResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T): GoogleLoginResult<T>(data)
    class Error<T>(message: String): GoogleLoginResult<T>(message = message)

}
