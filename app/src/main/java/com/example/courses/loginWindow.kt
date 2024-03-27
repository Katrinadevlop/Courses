package com.example.courses

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_window)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val exitInWindowsRegistration: Button = findViewById(R.id.exitButton)
        exitInWindowsRegistration.setOnClickListener{
            val activity = Intent(this, AccessPortal::class.java)
            startActivity(activity)
        }

        val registrationButton: Button = findViewById(R.id.registrationButton)
        registrationButton.setOnClickListener{
            val editTextTextEmailAddress: EditText = findViewById(R.id.editTextTextEmailAddress)
            val editTextTextPassword: EditText = findViewById(R.id.editTextTextPassword)
            val textEmailAddress = editTextTextEmailAddress.text.toString()
            val textPassword = editTextTextPassword.text.toString()

            val dbSqlite = DB_SQLite(this)

            val userVerification = dbSqlite.checkUser(textEmailAddress, textPassword)
            if (userVerification) {
                Toast.makeText(this, "Вход выполнен", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Данные не совпадают", Toast.LENGTH_SHORT).show()
                Log.e("DB_SQLite", "Ошибка сохранения данных")
            }
            val activityWindow = Intent(this, AccessPortal::class.java)
            startActivity(activityWindow)
        }
    }
}