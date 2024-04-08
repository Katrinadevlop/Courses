package com.example.courses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class AccessPortal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_portal)

        val registrationButton:Button = findViewById(R.id.authorizationButton)
        registrationButton.setOnClickListener {
            val activityWindows = Intent(this, RegistrationWindow::class.java)
            startActivity(activityWindows)
        }

        val loginButtons:Button = findViewById(R.id.loginButton)
        loginButtons.setOnClickListener{
            val activityWindow = Intent(this, loginWindow::class.java)
            startActivity(activityWindow)
        }
    }
}