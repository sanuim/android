package com.example.zad4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(Tasks())
    }

    fun setFragment(f: Fragment) {

        val ft = supportFragmentManager.beginTransaction()

        ft.replace(R.id.framelayout, f)
        ft.commit()
    }
}