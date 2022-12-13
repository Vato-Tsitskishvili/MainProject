package com.example.authenticationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        if(FirebaseAuth.getInstance().currentUser != null){
            Intent(this,MainActivity::class.java).also { startActivity(it) }
            finish()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.editText?.text.toString()
            val password = editTextPassword.editText?.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Mail or Password is not entered", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Intent(this, MainActivity::class.java).also { startActivity(it) }
                        finish()
                    } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        buttonRegistration.setOnClickListener{
            Intent(this,RegistrationActivity::class.java).also { startActivity(it) }
        }
        buttonResetPassword.setOnClickListener{
            Intent(this, ResetPasswordActivity::class.java).also { startActivity(it) }
        }

    }
}