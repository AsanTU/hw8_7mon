package com.example.hw8_7mon.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw8_7mon.ui.fragments.main.MainFragment
import com.example.hw8_7mon.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, MainFragment()).commit()
    }
}