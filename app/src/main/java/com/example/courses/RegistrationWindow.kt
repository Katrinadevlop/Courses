package com.example.courses

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class RegistrationWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_window)

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
            val add = dbSqlite.addUser(textEmailAddress, textPassword)
            if (add) {
                Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ошибка сохранения данных", Toast.LENGTH_SHORT).show()
                Log.e("DB_SQLite", "Ошибка сохранения данных")
            }
        }
    }
}