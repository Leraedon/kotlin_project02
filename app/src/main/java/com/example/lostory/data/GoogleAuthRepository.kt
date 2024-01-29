package com.example.lostory.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lostory.data.model.LoggedInUser
import com.example.lostory.ui.login.GoogleLoginResult
import com.example.lostory.ui.login.LoginFormState
import com.example.lostory.ui.login.LoginResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class GoogleAuthRepository {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val _userLiveData2 = MutableLiveData<FirebaseUser>()
    val rootRef: FirebaseFirestore = FirebaseFirestore.getInstance()

    //private val _userLiveData = MutableLiveData<FirebaseUser>()
    /*val userLiveData: LiveData<FirebaseUser>
        get() = _userLiveData*/
    val _userLiveData: MutableLiveData<GoogleLoginResult<LoggedInUser>> =
        MutableLiveData()
    val userLiveData2: LiveData<FirebaseUser>
            get() = _userLiveData2
    fun firebaseSignInWithGoogle(googleAuthCredential: AuthCredential): MutableLiveData<GoogleLoginResult<LoggedInUser>> {


        firebaseAuth.signInWithCredential(googleAuthCredential).addOnCompleteListener { authTask ->
            if(authTask.isSuccessful) {
                var firebaseUser: FirebaseUser? = firebaseAuth.currentUser
                if (firebaseUser != null) {
                    val uid = firebaseUser.uid
                    val name = firebaseUser.displayName
                    val email = firebaseUser.email
                    val user = LoggedInUser(uid = uid, name = name, email = email)
                    _userLiveData.value = GoogleLoginResult.Success(user)
                }
            } else {
                _userLiveData.value = authTask.exception?.message?.let {
                    GoogleLoginResult.Error(it)
                }
            }
        }

        return _userLiveData
    }
    fun getGoogleUser(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
                authTask ->
            if(authTask.isSuccessful) {
                _userLiveData2.postValue(firebaseAuth.currentUser)
            } else {
                /*_userLiveData2.value = authTask.exception?.message?.let {
                    GoogleLoginResult.Error(it)
                }*/
            }
        }
    }
}