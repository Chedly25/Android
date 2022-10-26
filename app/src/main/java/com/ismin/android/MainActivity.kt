package com.ismin.android
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val EXTRA_BOOK = "extra-book"
    private var books = Bookshelf()
    private lateinit var txvBook : TextView
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : BookAdapter
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val book = result.data?.getSerializableExtra(EXTRA_BOOK) as Book
            books.addBook(book)
            adapter.refreshData(books)
            recyclerView.adapter?.notifyDataSetChanged()
            //txvBook.text = book.toString()
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAddBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        txvBook = findViewById(R.id.a_main_txv_book)
        recyclerView = findViewById<RecyclerView>(R.id.a_rcv_bottles)
        adapter = BookAdapter(ArrayList(books.getAllBooks()))
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        btnAddBottle.setOnClickListener { view: View? ->
            val intent = Intent(this, CreateBookActivity::class.java)
            // start your next activity
            startForResult.launch(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_book -> {
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                books.deleteAllBooks()
                adapter.refreshData(books)
                adapter.notifyDataSetChanged()
                true
            }
            // If we got here, the user's action was not recognized.
            else -> super.onOptionsItemSelected(item)
        }
    }

}

