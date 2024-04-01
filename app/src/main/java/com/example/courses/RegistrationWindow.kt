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
            val dataBase = dbSqlite.writableDatabase
            val contentValues = ContentValues()
            contentValues.put("email", textEmailAddress)
            contentValues.put("password", textPassword)

          /*  val user = dbSqlite.getAllUsers()
            val textViews = findViewById<TextView>(R.id.textView3)
            val usersText = user.joinToString("\n") { "Email: ${it.first}, Password: ${it.second}" }
            textViews.text = usersText*/

            val add = dbSqlite.addUser(textEmailAddress, textPassword)
            if (add) {
                Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ошибка сохранения данных", Toast.LENGTH_SHORT).show()
                Log.e("DB_SQLite", "Ошибка сохранения данных")
            }

            /*val activityToSave = Intent(this, AccessPortal::class.java)
            startActivity(activityToSave)*/
        }
    }
}