package com.example.lostory.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lostory.data.GoogleAuthRepository
import com.example.lostory.data.model.LoggedInUser
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser

class GoogleLoginViewModel(private val authRepository: GoogleAuthRepository): ViewModel() {
    private var _googleLoginResult = MutableLiveData<GoogleLoginResult<LoggedInUser>>()
    val googleLoginResult: LiveData<GoogleLoginResult<LoggedInUser>>
        get() = _googleLoginResult

    //"10868639218-crannbs7bt9ep1um5q6oiomjm9pa4hfb.apps.googleusercontent.com"
    fun signInWithGoogle(googleAuthCredential: AuthCredential) {
        _googleLoginResult = authRepository.firebaseSignInWithGoogle(googleAuthCredential)
    }


    private val _userLivedata2 = authRepository.userLiveData2
    val userLiveData: LiveData<FirebaseUser>
        get() = _userLivedata2

    fun getUser(idToken: String) {
        authRepository.getGoogleUser(idToken)
    }
}