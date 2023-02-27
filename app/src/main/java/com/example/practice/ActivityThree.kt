package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        (findViewById<TextView>(R.id.One)).setOnClickListener {
            startActivity(Intent(this@ActivityThree,ActivityOne::class.java))
        }
        (findViewById<TextView>(R.id.Two)).setOnClickListener {
            startActivity(Intent(this@ActivityThree,ActivityTwo::class.java))
        }
        (findViewById<TextView>(R.id.Three)).setOnClickListener {
            startActivity(Intent(this@ActivityThree,ActivityThree::class.java))
        }
    }
}