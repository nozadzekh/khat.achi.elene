package com.example.khatachi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var welcome : TextView
    private lateinit var signup :TextView
    private lateinit var enteryouremail : EditText
    private lateinit var enteryourpassword :EditText
    private lateinit var next : TextView
    private lateinit var firebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        LoginListeners()
        init()

    }

    private fun LoginListeners() {
    next.setOnClickListener{
        val email = enteryouremail.toString()
        val password = enteryourpassword.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText( this, "your email or password in empty", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompListener { task ->
            if (task.isSuccessful) {
                startActivity(Intent( this, ProfileFragment::class.java ))
                finish()
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
                }

            }
        }
        private fun init(){
            enteryouremail=findViewById(R.id.enteryouremail)
            enteryourpassword=findViewById(R.id.enteryourpassword)
            next=findViewById(R.id.next)
            welcome=findViewById(R.id.welcome)
            signup=findViewById(R.id.signup)

    }
    }
}
