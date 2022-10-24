package com.ismin.android
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val EXTRA_BOOK = "extra-book"
    private lateinit var books : Bookshelf
    private lateinit var txvBook : TextView
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val book = result.data?.getSerializableExtra(EXTRA_BOOK) as Book
            books.addBook(book)
            //txvBook.text = book.toString()
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAddBottle = findViewById<Button>(R.id.a_main_btn_create_book)
        txvBook = findViewById(R.id.a_main_txv_book)
        btnAddBottle.setOnClickListener { view: View? ->
            val intent = Intent(this, CreateBookActivity::class.java)
            // start your next activity
            startForResult.launch(intent)
        }
    }

}

