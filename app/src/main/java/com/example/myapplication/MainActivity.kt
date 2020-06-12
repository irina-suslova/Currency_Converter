package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView2.visibility = View.INVISIBLE
        editTextNumberDecimal.visibility = View.INVISIBLE
        button3.visibility = View.INVISIBLE
        textView3.visibility = View.INVISIBLE
        textView4.visibility = View.INVISIBLE

        var currency: String = "currency"
        val rubl = "₽"
        val dollar = "$"
        val rate: Int = 74
        var checher: Boolean = false

        button1.setOnClickListener {    // rubl -> dollar
            if (!checher) {
                checher = true
                textView2.visibility = View.VISIBLE
                editTextNumberDecimal.visibility = View.VISIBLE
                button3.visibility = View.VISIBLE
                textView3.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
            }
            editTextNumberDecimal.setText("")
            textView3.text = ""
            currency = "dollar"
        }

        button2.setOnClickListener {    // dollar -> rubl
            if (!checher) {
                checher = true
                textView2.visibility = View.VISIBLE
                editTextNumberDecimal.visibility = View.VISIBLE
                button3.visibility = View.VISIBLE
                textView3.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
            }
            editTextNumberDecimal.setText("")
            textView3.text = ""
            currency = "ruble"
        }

        button3.setOnClickListener {
            val inputText = editTextNumberDecimal.text
            var text: String = "Some text"
            if (inputText == null || inputText.toString() == "") {
                text = "Введите сумму"
            } else {
                val sum = inputText.toString()
                when (currency) {
                    "dollar" -> text = "$sum $rubl = ${(sum.toDouble() / rate)} $dollar"
                    "ruble" -> text = "$sum $dollar = ${sum.toDouble() * rate} $rubl"
                }
            }
            textView3.setText(text)
        }

    }

}