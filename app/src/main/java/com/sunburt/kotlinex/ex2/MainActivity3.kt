package com.sunburt.kotlinex.ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.sunburt.kotlinex.R
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val chk1 = findViewById<CheckBox>(R.id.chk1)
        val chk2 = findViewById<CheckBox>(R.id.chk2)
        val chk3 = findViewById<CheckBox>(R.id.chk3)
        val chk4 = findViewById<CheckBox>(R.id.chk4)

        val string = ArrayList<String>()
        if (chk1.isChecked)
            string.add("A")
        if (chk2.isChecked)
            string.add("B")
        if (chk3.isChecked)
            string.add("C")
        if (chk4.isChecked)
            string.add("D")
        val size = string.size
        val arr = CharArray(string.size)
        val sign = string.toArray(arrayOf(CharArray(string.size)))
        val res = ""
        for (i in sign)
            res + i
        btn.setOnClickListener {
            Toast.makeText(this, "Result: $res", Toast.LENGTH_SHORT).show()
        }
    }
}