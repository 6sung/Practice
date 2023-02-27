package com.example.practice

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
    }
}

class BackgroundAsyncTask(
    val progressbar : ProgressBar,
    val progressText : TextView
):AsyncTask<Int,Int,Int>(){
    override fun doInBackground(vararg params: Int?): Int {
        TODO("Not yet implemented")
    }

}