package com.example.practice

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        //SharedPreference 사용법
        findViewById<TextView>(R.id.create).setOnClickListener {
            //create
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            // MODE_PRIVATE -> 현재 앱에서만 사용을 하겠다.
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key1","hello1")
            editor.putString("key2","hello2")
            editor.commit()
        }
        findViewById<TextView>(R.id.read).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name",Context.MODE_PRIVATE)
            val valueOne = sharedPreferences.getString("key1","Wrong1")
            val valueTwo = sharedPreferences.getString("key2","Wrong2")
            Log.d("testt",valueOne!!)
            Log.d("testt",valueTwo!!)
        }
        findViewById<TextView>(R.id.update).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name",Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key1","hello hello ")
            editor.commit()
        }
        findViewById<TextView>(R.id.delete).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name",Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }
    }
}