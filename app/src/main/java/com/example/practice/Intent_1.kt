package com.example.practice

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class Intent_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        //암시적 인탠트
        // 전화 sns 구글플레이스토어 웹사이트
        val implicit_intent : TextView = findViewById(R.id.implicit_intent)
        implicit_intent.setOnClickListener {
            val intent : Intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:"+"010-2875-2784")
            )
            startActivity(intent)

        }
        val intent_one : TextView = findViewById(R.id.intent_one)
        intent_one.setOnClickListener {
            val intent: Intent = Intent()
            val componentName: ComponentName =
                ComponentName("com.example.practice", "com.example.practice.Intent_2")

            intent.component = componentName
            startActivity(intent)
        }
        (findViewById<TextView>(R.id.intent_two)).apply{
            this.setOnClickListener {
                startActivity(
                    Intent(this@Intent_1, Intent_2::class.java)
                )
            }
        }
        (findViewById<TextView>(R.id.intent_three)).apply{
            this.setOnClickListener {
                val intent = Intent(this@Intent_1,Intent_2::class.java)
                intent.putExtra("extra-data","data-one")
                startActivity(intent)
            }
        }
        //명시적 인텐트 + 결과받기
        (findViewById<TextView>(R.id.intent_four)).apply{
            this.setOnClickListener {
                val intent = Intent(this@Intent_1,Intent_2::class.java)
                startActivityForResult(intent,1)
            }
        }
        val startActivityLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            when(it.resultCode){
                RESULT_OK -> {
                    Log.d("dataa", it.data?.extras?.getString("result")!!)
                }
            }
        }
        (findViewById<TextView>(R.id.intent_five)).apply{
            this.setOnClickListener {
                val intent = Intent(this@Intent_1,Intent_2::class.java)
                startActivityLauncher.launch(intent)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> {
                when(resultCode){
                    RESULT_OK -> {
                        val data:String? = data?.extras?.getString("result")
                        Log.d("dataa",data!!)
                    }
                }
            }
            2 -> {

            }
        }
        (findViewById<TextView>(R.id.intent_six)).apply{
            this.setOnClickListener {
                val intent = Intent(this@Intent_1,Intent_2::class.java).apply{
                    val imageUri = Uri.parse("android.resource://"+ packageName + "/drawable/" + "download1")
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_STREAM, imageUri)
                    this.setType("image/*")
                }
                startActivity(intent)

            }
        }
    }
}