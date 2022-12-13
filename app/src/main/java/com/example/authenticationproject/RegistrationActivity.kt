package com.example.authenticationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.buttonRegistration
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        buttonRegistration.setOnClickListener{
            val email = editTextEmailRegistration.editText?.text.toString()
            val password = editTextPasswordRegistration.editText?.text.toString()
            val confirmPassword = editTextConfirmPassword.editText?.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "E-mail or Password is Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(confirmPassword == password ){

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {task ->
                        if(task.isSuccessful){
                             FirebaseAuth.getInstance().currentUser?.sendEmailVerification()?.addOnSuccessListener {
                                Intent(this, MainActivity::class.java).also { startActivity(it) }
                                finish()
                             }

                        }else{
                            Toast.makeText(this,"E-mail or Password is Empty", Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
    }
}