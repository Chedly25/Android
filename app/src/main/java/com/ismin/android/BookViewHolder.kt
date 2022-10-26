package com.ismin.android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class BookViewHolder (rootView: View) : RecyclerView.ViewHolder(rootView){
    var txvTitle = rootView.findViewById<TextView>(R.id.title)
    var txvAuthor = rootView.findViewById<TextView>(R.id.author)
    var txvDate = rootView.findViewById<TextView>(R.id.date)
}