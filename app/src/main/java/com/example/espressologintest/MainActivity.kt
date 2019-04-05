package com.example.espressologintest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        confirmar.setOnClickListener {
            val loginText = username.editableText.toString()
            val passwordText = password.editableText.toString()
            val isLoginSuccessful = Login().doLogin(loginText, passwordText)
            if (isLoginSuccessful) {
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_LONG).show()
            }
        }
    }

}
