package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragementManager = supportFragmentManager
        val fragmentFirst = FragmentFirst()

        (findViewById<TextView>(R.id.add)).setOnClickListener {
            val transaction = fragementManager.beginTransaction()
            //프래그먼트에 데이터를 전달하는 방법
            val bundle = Bundle()
            bundle.putString("key","hello")
            fragmentFirst.arguments = bundle

            transaction.replace(R.id.root, fragmentFirst, "fragment_first_tag")
            transaction.commit()
        }
        (findViewById<TextView>(R.id.remove)).setOnClickListener {
            val transaction = fragementManager.beginTransaction()
            transaction.remove(fragmentFirst)
            transaction.commit()
        }
        (findViewById<TextView>(R.id.access_fragmemt)).setOnClickListener {
            //xml 에 있는 fragment 찾는 방법
            //val fragmentFirst = supportFragmentManager.findFragmentById(R.id.frament_first) as FragmentFirst
            //fragmentFirst.printTestLog()

            supportFragmentManager.findFragmentByTag("first_first_tag") as FragmentFirst


        }
    }
    fun prinTestLog(){
        Log.d("testt","print test log")
    }
}