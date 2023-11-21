package com.android.intentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    companion object{
        const val KEY_NAME = "key_name"
        const val KEY_NIM = "key_nim"
        const val KEY_PHONE = "key_phone"
        const val KEY_EMAIL = "key_email"
    }
    private var phoneNumber: String? = null
    private var emailAddress: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName:TextView = findViewById(R.id.tv_name)
        val tvNim:TextView = findViewById(R.id.tv_nim)
        val tvPhone:TextView = findViewById(R.id.tv_phone)
        val tvEmail:TextView = findViewById(R.id.tv_email)
        val btnPhoneCall = findViewById<Button>(R.id.btn_phone_call)
        val btnEmailSend = findViewById<Button>(R.id.btn_email_send)

        val name = intent.getStringExtra(KEY_NAME)
        val nim = intent.getStringExtra(KEY_NIM)
        val phone = intent.getStringExtra(KEY_PHONE)
        val email = intent.getStringExtra(KEY_EMAIL)
        tvName.text = String.format("Nama : %s", name)
        tvNim.text = String.format("NIM: %s", nim)
        tvPhone.text = String.format("No. HP: %s", phone)
        tvEmail.text = String.format("Email: %s", email)

        phoneNumber = phone
        btnPhoneCall.setOnClickListener {
            run {
                val callPhoneIntent =Intent()
                callPhoneIntent.action = Intent.ACTION_DIAL
                callPhoneIntent.data = Uri.parse("tel:$phoneNumber")
                startActivity(callPhoneIntent)
            }
        }

        emailAddress = email
        btnEmailSend.setOnClickListener {
            val sendEmailIntent = Intent(Intent.ACTION_SEND)
            sendEmailIntent.type = "text/plain"
            sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
            sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Belajar Intent")
            startActivity(Intent.createChooser(sendEmailIntent, "Kirim"))
        }
    }
}