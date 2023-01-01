package com.example.project

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R

class MyAdapter(context: Context, cursor: Cursor?) : CursorRecyclerViewAdapter<MyAdapter.ViewHolder>(context, cursor) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.name_text_view)
        val titleTextView: TextView = view.findViewById(R.id.title_text_view)
        val statusTextView: TextView = view.findViewById(R.id.status_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: ViewHolder, cursor: Cursor) {
        val name = cursor.getString(cursor.getColumnIndex("name"))
        val title = cursor.getString(cursor.getColumnIndex("title"))
        val status = cursor.getString(cursor.getColumnIndex("status"))

        holder.nameTextView.text = name
        holder.titleTextView.text = title
        holder.statusTextView.text = status
    }
}