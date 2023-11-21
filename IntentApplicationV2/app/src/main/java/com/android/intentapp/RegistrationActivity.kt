package com.android.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {
    private var inputNamaLengkap : EditText? = null;
    private  var inputNIM : EditText? = null;
    private var inputNoHandphone : EditText? = null;
    private var inputEmail : EditText? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        inputNamaLengkap = findViewById(R.id.inputNamaLengkap)
        inputNIM = findViewById(R.id.inputNIM)
        inputNoHandphone = findViewById(R.id.inputNoHandphone)
        inputEmail = findViewById(R.id.inputEmail)

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            run {
                val name = inputNamaLengkap!!.text.toString().trim{ it <= ' ' }
                val nim = inputNIM!!.text.toString().trim { it <= ' ' }
                val phone = inputNoHandphone!!.text.toString().trim { it <= ' ' }
                val email = inputEmail!!.text.toString().trim { it <= ' ' }
                var isEmptyField = false
                if (name.isEmpty()) {
                    inputNamaLengkap!!.error = "Field harus diisi"
                    isEmptyField = true
                }
                if (nim.isEmpty()) {
                    inputNIM!!.error = "Field harus diisi"
                    isEmptyField = true
                }
                if (phone.isEmpty()) {
                    inputNoHandphone!!.error = "Field harus diisi"
                    isEmptyField = true
                }
                if (email.isEmpty()) {
                    inputEmail!!.error = "Field harus diisi"
                    isEmptyField = true
                }

                if (!isEmptyField) {
                    val detailIntent = Intent(this, DetailActivity::class.java)
                    detailIntent.putExtra(DetailActivity.KEY_NAME, name)
                    detailIntent.putExtra(DetailActivity.KEY_NIM, nim)
                    detailIntent.putExtra(DetailActivity.KEY_PHONE, phone)
                    detailIntent.putExtra(DetailActivity.KEY_EMAIL, email)
                    startActivity(detailIntent)
                }
            }
        }

    }
}