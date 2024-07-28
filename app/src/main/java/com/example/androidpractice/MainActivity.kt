package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txtResult : TextView
    lateinit var editNumber1 : EditText
    lateinit var editNumber2 : EditText
    lateinit var btnCalculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_demo)
        txtResult = findViewById(R.id.txtResult)
        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)
        btnCalculate = findViewById(R.id.btnCalculator)

        btnCalculate.setOnClickListener {
            try {
                val strNumber1 = editNumber1.editableText.toString()
                val strNumber2 = editNumber2.editableText.toString()

                val number1 = strNumber1.toInt()
                val number2 = strNumber2.toInt()

                val result = number1 + number2
                txtResult.text = "$result"
            } catch (e : Exception) {
                Log.e("Calculate", e.toString())
            }
        }
    }
}