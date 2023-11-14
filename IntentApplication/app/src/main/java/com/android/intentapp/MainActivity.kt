package com.android.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart: Button = findViewById(R.id.btn_start)
        btnStart.setOnClickListener {
            run {
                val registrationActivity = Intent(this, RegistrationActivity::class.java)
                startActivity(registrationActivity)
            }
        }
    }
}