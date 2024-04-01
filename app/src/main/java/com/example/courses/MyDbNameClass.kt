package com.example.courses

import android.provider.BaseColumns

object MyDbNameClass : BaseColumns {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Courses.db"
    const val TABLE_NAME = "Users"
    const val COLUMN_EMAIL = "email"
    const val COLUMN_PASSWORD = "password"

    const val CREATE_TABLE = ("CREATE TABLE IF NOT EXISTS ${MyDbNameClass.TABLE_NAME} (${BaseColumns._ID} INTEGER PRIMARY KEY, ${MyDbNameClass.COLUMN_EMAIL} TEXT, ${MyDbNameClass.COLUMN_PASSWORD} TEXT)")
    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}