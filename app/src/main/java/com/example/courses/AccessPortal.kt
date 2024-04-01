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
<<<<<<< HEAD
=======

>>>>>>> 419a4e7c5160931d6c21c38a0d5455277192a1d4
        registrationButton.setOnClickListener {
            val activityWindows = Intent(this, RegistrationWindow::class.java)
            startActivity(activityWindows)
        }

<<<<<<< HEAD
        val loginButtton:Button = findViewById(R.id.loginButton)
        loginButtton.setOnClickListener{
            val activityWindow = Intent(this, loginWindow::class.java)
            startActivity(activityWindow)
        }
=======

>>>>>>> 419a4e7c5160931d6c21c38a0d5455277192a1d4
    }
}