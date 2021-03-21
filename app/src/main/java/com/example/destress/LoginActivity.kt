package com.example.destress

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {
    lateinit var email_edittext_login: EditText
    lateinit var password_edittext_login: EditText
    lateinit var login_button_login: Button
    lateinit var back_to_register_textview: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        addControls()
        addEvents()
    }

    private fun addEvents() {
        beginActivity()
        login_button_login.setOnClickListener {
            if(email_edittext_login.text.toString() == "1")
            {
                if(password_edittext_login.text.toString()=="2")
                        connectMainActivity()
                else Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                    }
            else Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
        }

        back_to_register_textview.setOnClickListener {
            connectRegisterActivity()
        }

    }
    private fun beginActivity() {
        var intent: Intent = Intent(this, SplashScreenActivity::class.java)
        startActivity(intent)
    }
    
    private fun connectRegisterActivity() {
        var intent: Intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun connectMainActivity() {
        var intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun addControls() {
        email_edittext_login = findViewById(R.id.email_edittext_login)
        password_edittext_login = findViewById(R.id.password_edittext_login)
        login_button_login = findViewById(R.id.login_button_login)
        back_to_register_textview = findViewById(R.id.back_to_register_textview)
    }
}
