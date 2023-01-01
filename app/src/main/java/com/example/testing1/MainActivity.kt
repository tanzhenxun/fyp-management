package com.example.testing1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        // Connect to the database using a helper class
        val dbHelper = MyHelper(this)
        val db = dbHelper.readableDatabase

        // Define the columns to retrieve
        val projection = arrayOf(BaseColumns._ID, "status")

        // Define the selection criteria
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf("1")  // Replace with the ID of the form submission you want to retrieve

        // Execute the query
        val cursor = db.query("assignment", projection, selection, selectionArgs, null, null, null)

        // Check the status of the form submission
        if (cursor.moveToFirst()) {
            val status = cursor.getString(cursor.getColumnIndex("status"))
            if (status == "approved") {
                button.setBackgroundColor(Color.GREEN)
            } else if (status == "rejected") {
                button.setBackgroundColor(Color.RED)
            }
        }

        // Remember to close the cursor and the database connection when you are done
        cursor.close()
        db.close()

    }
}