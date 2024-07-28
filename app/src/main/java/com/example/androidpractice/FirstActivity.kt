package com.example.androidpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

fun Activity.showMessage(msg: String?) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        showMessage("onCreate")

        findViewById<Button>(R.id.btnGoToSecondActivity).setOnClickListener {
            // go to next activity
            val intent = Intent(this, SecondActivity::class.java)
            intent.apply {
                putExtra("MSG", "OK")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnGoToSecondActivityAndReturn).setOnClickListener {
            // go to next activity
            val intent = Intent(this, SecondActivity::class.java)
            intent.apply {
                putExtra("MSG", "OK")
            }
            startActivityForResult(intent, RequestCode.myRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RequestCode.myRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                data?.getStringExtra("MSG_BACK").let {
                    showMessage(it)
                }
            }
        }
    }

    object RequestCode {
        const val myRequestCode = 123
    }

    override fun onRestart() {
        super.onRestart()
        showMessage("onRestart")
    }

    override fun onStart() {
        super.onStart()
        showMessage("onStart")
    }

    override fun onResume() {
        super.onResume()
        showMessage("onResume")
    }

    override fun onPause() {
        super.onPause()
        showMessage("onPause")
    }

    override fun onStop() {
        super.onStop()
        showMessage("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showMessage("onDestroy")
    }
}