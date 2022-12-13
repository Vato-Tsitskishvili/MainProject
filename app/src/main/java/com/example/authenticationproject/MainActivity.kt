package com.example.authenticationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(app_bar)

        app_bar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if(itemId == R.id.changePassword){
            Intent(this, ChangePasswordActivity::class.java).also { startActivity(it) }
            finish()
        }
        if(itemId == R.id.logOut){
            FirebaseAuth.getInstance().signOut()
            Intent(this, LoginActivity::class.java).also { startActivity(it) }
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}