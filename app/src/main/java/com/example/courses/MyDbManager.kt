package com.example.courses

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.icu.text.CaseMap.Title

class MyDbManager(context: Context){
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null
    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, context: String){
        val value = ContentValues().apply {
            put(MyDbNameClass.COLUMN_EMAIL, title)
            put(MyDbNameClass.COLUMN_PASSWORD, context)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, value)
    }

    fun readDbData() : ArrayList<String> {
        val dataList = arrayListOf<String>()
        var cursor = db?.query(MyDbNameClass.TABLE_NAME, null, null, null, null, null, null)
        while(cursor?.moveToNext()!!){
            val dataText = cursor?.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.TABLE_NAME))//
            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }

    fun closeDB(){
        myDbHelper.close()
    }
}