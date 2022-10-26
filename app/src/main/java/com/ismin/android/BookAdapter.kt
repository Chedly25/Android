package com.ismin.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (private var books : ArrayList<Book>) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: BookViewHolder, position: Int) {
        val (title, author, date) = this.books[position]
        viewholder.txvTitle.text = title
        viewholder.txvAuthor.text = author
        viewholder.txvDate.text = date
    }

    fun refreshData(livres : Bookshelf){
        books = ArrayList(livres.getAllBooks())
    }

    override fun getItemCount(): Int {
        return this.books.size
    }
}