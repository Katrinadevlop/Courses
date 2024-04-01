package com.example.courses

<<<<<<< HEAD
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
=======
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
>>>>>>> 419a4e7c5160931d6c21c38a0d5455277192a1d4

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
<<<<<<< HEAD
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
=======
            val activityToSave = Intent(this, AccessPortal::class.java)
            startActivity(activityToSave)
>>>>>>> 419a4e7c5160931d6c21c38a0d5455277192a1d4
        }
    }
}