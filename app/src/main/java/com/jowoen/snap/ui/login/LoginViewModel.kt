package com.jowoen.snap.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jowoen.snap.data.repository.Authentication
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val auth: Authentication
) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    val loading = MutableLiveData(false)

    fun login(email: String, password: String) {
        loading.value = true
        auth.login(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                _loginResult.value = task.isSuccessful
            }
    }
}