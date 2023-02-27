package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_01)

        val textViewOne : TextView = findViewById(R.id.textViewOne)
        val buttonOne : Button = findViewById(R.id.buttonOne)

        buttonOne.setOnClickListener {
            Log.d("testt","버튼 클릭")
        }
    }
}