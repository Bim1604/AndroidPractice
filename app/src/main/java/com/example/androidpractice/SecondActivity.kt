package com.example.androidpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg = intent?.getStringExtra("MSG")
//        msg?.let { showMessage(it) }
        val intent = Intent()
        intent.apply {
            putExtra("MSG_BACK", "$msg back")
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}