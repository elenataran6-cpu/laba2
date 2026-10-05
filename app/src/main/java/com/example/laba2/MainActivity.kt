package com.example.laba2

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)

        textView.text = ""

        button.setOnClickListener {
            val input = editText.text.toString().trim()

            if (input.isNotEmpty()) {
                textView.text = getString(R.string.greeting_format, input)
            } else {
                textView.text = ""
            }

            // Скрываем клавиатуру
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE)
                    as InputMethodManager
            imm.hideSoftInputFromWindow(editText.windowToken, 0)

            // Убираем курсор и фокус с поля
            editText.clearFocus()
        }
    }
}