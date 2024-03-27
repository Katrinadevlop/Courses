package com.example.courses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class AccessPortal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_portal)

        val registrationButton:Button = findViewById(R.id.registrationButton)
        registrationButton.setOnClickListener {
            val activityWindows = Intent(this, RegistrationWindow::class.java)
            startActivity(activityWindows)
        }

        val loginButtton:Button = findViewById(R.id.loginButton)
        loginButtton.setOnClickListener{
            val activityWindow = Intent(this, loginWindow::class.java)
            startActivity(activityWindow)
        }
    }
}