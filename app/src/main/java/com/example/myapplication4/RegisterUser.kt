package com.example.myapplication4

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

// Inisialisasi FirebaseAuth
val auth = FirebaseAuth.getInstance()
val database = FirebaseDatabase.getInstance().reference

fun registerUser(email: String, password: String, fullName: String, phoneNumber: String, otherDetails: Map<String, String>) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Dapatkan user ID
                val userId = auth.currentUser?.uid ?: ""

                // Simpan data pengguna di Realtime Database
                val userMap = hashMapOf(
                    "fullName" to fullName,
                    "phoneNumber" to phoneNumber
                )
                userMap.putAll(otherDetails)

                database.child("users").child(userId).setValue(userMap)
                    .addOnSuccessListener {
                        // Data berhasil disimpan
                        println("User registered and data saved to Realtime Database.")
                    }
                    .addOnFailureListener {
                        // Gagal menyimpan data
                        println("Failed to save user data: ${it.message}")
                    }
            } else {
                // Gagal registrasi
                println("Registration failed: ${task.exception?.message}")
            }
        }
}
