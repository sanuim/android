package com.example.zad3


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Kalkulator"

        var textResult: TextView = findViewById(R.id.textResult)
        var c1: Button = findViewById(R.id.c1)
        var c2: Button = findViewById(R.id.c2)
        var c3: Button = findViewById(R.id.c3)
        var c4: Button = findViewById(R.id.c4)
        var c5: Button = findViewById(R.id.c5)
        var c6: Button = findViewById(R.id.c6)
        var c7: Button = findViewById(R.id.c7)
        var c8: Button = findViewById(R.id.c8)
        var c9: Button = findViewById(R.id.c9)
        var c0: Button = findViewById(R.id.c0)
        var sum: Button = findViewById(R.id.sum)
        var mul: Button = findViewById(R.id.mul)
        var div: Button = findViewById(R.id.div)
        var sub: Button = findViewById(R.id.sub)
        var doResult: Button = findViewById(R.id.doResult)
        var erase: Button = findViewById(R.id.erase)

        textResult.text = ""

        c1.setOnClickListener {
            textResult.append("1")
        }
        c2.setOnClickListener {
            textResult.append("2")
        }

        c3.setOnClickListener {
            textResult.append("3")
        }
        c4.setOnClickListener {
            textResult.append("4")
        }

        c5.setOnClickListener {
            textResult.append("5")
        }

        c6.setOnClickListener {
            textResult.append("6")
        }

        c7.setOnClickListener {
            textResult.append("7")
        }

        c8.setOnClickListener {
            textResult.append("8")
        }

        c9.setOnClickListener {
            textResult.append("9")
        }

        c0.setOnClickListener {
            textResult.append("0")
        }


        sum.setOnClickListener {
            textResult.append("+")
        }
        sub.setOnClickListener {
            textResult.append("-")
        }
        div.setOnClickListener {
            textResult.append("/")
        }
        mul.setOnClickListener {
            textResult.append("*")
        }

        erase.setOnClickListener {
            textResult.text = ""
        }

        doResult.setOnClickListener {
            val text = textResult.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                textResult.text = longResult.toString()
            } else {
                textResult.text = result.toString()
            }
        }
    }
}