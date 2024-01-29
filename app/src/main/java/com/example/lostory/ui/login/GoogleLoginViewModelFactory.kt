package com.example.lostory.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lostory.data.GoogleAuthRepository
import com.example.lostory.data.LoginDataSource
import com.example.lostory.data.LoginRepository

class GoogleLoginViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoogleLoginViewModel::class.java)) {
            return GoogleLoginViewModel(
                authRepository = GoogleAuthRepository()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}