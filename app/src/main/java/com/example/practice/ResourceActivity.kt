package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)
        findViewById<TextView>(R.id.text).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name)
            it.background = resources.getDrawable(R.drawable.download2, null)
            // it.background = ContextCompat.getDrawable(this,R.drawable.arrows)
            //it.background = ResourcesCompat.getDrawable(resources, R.drawable.arrows, null)
        }
    }
}