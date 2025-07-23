package com.example.snap.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.snap.data.firebase.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepo: AuthRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    val loading = MutableLiveData(false)

    fun login(email: String, password: String) {
        loading.value = true
        authRepo.login(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                _loginResult.value = task.isSuccessful
            }
    }

    fun register(email: String, password: String) {
        loading.value = true
        authRepo.register(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                _loginResult.value = task.isSuccessful
                if (task.isSuccessful) {
                    authRepo.insertUserToFirestore()
                }
            }
    }
}