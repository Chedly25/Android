package com.ismin.android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class CreateBookActivity : AppCompatActivity() {
    val EXTRA_BOOK = "extra-book"
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)
        val btnSave = findViewById<Button>(R.id.a_create_book_btn_save)

        btnSave.setOnClickListener { view: View? ->

            stopActivityAndReturnResult()
        }
        //val intent = Intent(this, CreateBookActivity::class.java)
        //startForResult.launch(intent)
    }
    fun stopActivityAndReturnResult() {
        val titre = findViewById<EditText>(R.id.a_create_book_edt_title).text.toString()
        val auteur = findViewById<EditText>(R.id.a_create_book_edt_author).text.toString()
        val date = findViewById<EditText>(R.id.a_create_book_edt_date).text.toString()
        val bouquin = Book(
            title = titre,
            author = auteur,
            date = date
        )
        val returnIntent = Intent()
        returnIntent.putExtra(EXTRA_BOOK, bouquin)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

}