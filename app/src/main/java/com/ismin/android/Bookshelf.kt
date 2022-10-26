package com.ismin.android
class Bookshelf {
    private val mapLivres : HashMap<String?, Book> = HashMap()

    fun addBook(book : Book) {
        mapLivres[book.title] = book
    }

    fun getBook(titre : String): Book {
        return (mapLivres[titre])?: throw RuntimeException("No book with title: $titre")
    }

    fun getBooksOf(author : String): List<Book> {
        return mapLivres.filter { it.value?.author == author }.values.sortedBy { it?.title }.toList()
    }

    fun getAllBooks() : List<Book> {
        return mapLivres.values.sortedBy { it.title }.toList()
    }
    fun getTotalNumberOfBooks() : Int{
        return mapLivres.count()
    }
    fun deleteBook(book : Book) : Boolean{
        var newMap = mapLivres.remove(book.title)
        return true
    }
    fun deleteAllBooks(){
        mapLivres.clear()
    }
}