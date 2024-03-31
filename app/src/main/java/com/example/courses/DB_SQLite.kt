package com.example.courses
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB_SQLite(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Courses.db"
        private const val TABLE_NAME = "Users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
    }



    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT)")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(email: String, password: String): Boolean {
        val db = this.writableDatabase
        val valuesEmail = ContentValues()
        valuesEmail.put(COLUMN_EMAIL, email)
        val emailRowId = db.insert(TABLE_NAME, null, valuesEmail)

        val valuesPassword = ContentValues()
        valuesPassword.put(COLUMN_PASSWORD, password)
        val passwordRowId = db.insert(TABLE_NAME, null, valuesPassword)

        db.close()
        return emailRowId != -1L && passwordRowId != -1L
    }

    /*fun addUser(email: String, password: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(COLUMN_EMAIL, email)
        val emailRowId = db.insert(TABLE_NAME, null, values)

        values.clear()

        values.put(COLUMN_PASSWORD, password)
        val passwordRowId = db.insert(TABLE_NAME, null, values)

        *//*val values = ContentValues().apply {
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
        }
        val newRowId = db.insert(TABLE_NAME, null, values)*//*
        db.close()
        return emailRowId != -1L && passwordRowId != -1L
    }*/

    /*   CREATE TABLE Users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    email TEXT NOT NULL,
    password TEXT NOT NULL
    )
*/
    fun getAllUsers(): ArrayList<Pair<String, String>> {
        val users = ArrayList<Pair<String, String>>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor.use {
            val columnIndexEmail = it.getColumnIndexOrThrow(COLUMN_EMAIL)
            val columnIndexPassword = it.getColumnIndexOrThrow(COLUMN_PASSWORD)
            while (it.moveToNext()) {
                val email = it.getString(columnIndexEmail)
                val password = it.getString(columnIndexPassword)
                users.add(Pair(email, password))
            }
        }
        return users
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?", arrayOf(email, password))
        val count = cursor.count
        cursor.close()
        return count > 0
    }
}