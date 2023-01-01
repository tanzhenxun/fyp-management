package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            val username = username.text.toString().trim()
            val password = password.text.toString().trim()

            if (username == "admin" && password == "admin") {
                // Login successful
                Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                openMainActivity()
            } else {
                // Login failed
                Toast.makeText(this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }


}