package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread = Thread.currentThread()
    }
}