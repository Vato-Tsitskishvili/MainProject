package com.example.authenticationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.buttonResetPassword
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        buttonResetPassword.setOnClickListener{
            val email = editTextEmailReset.editText?.text.toString()

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Check the E-mail", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}