package com.example.authenticationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        buttonNewPassword.setOnClickListener{

            val newPassword = editTextChangePassword.editText?.text.toString()

            if(newPassword.length > 6){

                FirebaseAuth.getInstance()
                    .currentUser?.updatePassword(newPassword)
                    ?.addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Success!", Toast.LENGTH_SHORT).show()
                            Intent(this,LoginActivity::class.java).also { startActivity(it) }
                            finish()
                        }else{
                            Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}