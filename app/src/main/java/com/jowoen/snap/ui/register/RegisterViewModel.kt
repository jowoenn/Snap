package com.jowoen.snap.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jowoen.snap.data.repository.Authentication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val auth: Authentication
) : ViewModel() {

    private val _registerResult = MutableLiveData<Boolean>()
    val registerResult: LiveData<Boolean> = _registerResult

    val loading = MutableLiveData(false)

    fun register(email: String, password: String) {
//        loading.value = true
//        authRepo.register(email, password)
//            .addOnCompleteListener { task ->
//                loading.value = false
//                _registerResult.value = task.isSuccessful
//                if (task.isSuccessful) {
//                    authRepo.addUser()
//                }
//            }
    }
}