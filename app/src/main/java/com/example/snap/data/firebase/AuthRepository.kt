package com.example.snap.data.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepository @Inject constructor() {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    fun login(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun register(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    fun insertUserToFirestore() {
        val uuid = auth.currentUser?.uid ?: return
        val username = uuid.take(6)
        val userMap = mapOf(
            "uuid" to uuid,
            "username" to username,
            "friends" to listOf<String>()
        )
        firestore.collection("users").document(uuid).set(userMap)
    }
}