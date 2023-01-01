package com.example.testing1

import android.content.Context;
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class MyHelper(context:Context?) : SQLiteOpenHelper(context, "mydatabase", null, 1) {

        override fun onCreate(db: SQLiteDatabase?) {
                // Create a table in the database
                val createTableSql = "CREATE TABLE Assignment (" +
                        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                        "name TEXT," +
                        "title TEXT," +
                        "image_url TEXT,"+
                        "status TEXT" +
                        ")"
                db?.execSQL(createTableSql)
                db?.execSQL("INSERT INTO Assignment(name,title,image_url,status) Values('Tan Zhen Xun','Proposal','/drawable/title_icon.png','approved')")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                // Upgrade the database schema if necessary
        }
}
