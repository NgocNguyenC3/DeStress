package com.example.destress

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import org.json.JSONObject

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
            var username = email_edittext_login.text.toString()
            var password = password_edittext_login.text.toString()

            var jsonbody = mapOf<String, String>("username" to username, "password" to password)

            var stat = 0

            Fuel.post("http://10.0.2.2:8000/login")
                .jsonBody(JSONObject(jsonbody).toString())
                .response { request, response, result ->
                    stat = response.statusCode
                }

            if (stat == 0) {
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()
                connectMainActivity()
            }
            else {
                Toast.makeText(this, String.format("Login failed. Status: %d", stat), Toast.LENGTH_SHORT).show()
            }
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
        intent.putExtra("username", email_edittext_login.text.toString())
        intent.putExtra("password", password_edittext_login.text.toString())

        startActivity(intent)
    }

    private fun addControls() {
        email_edittext_login = findViewById(R.id.email_edittext_login)
        password_edittext_login = findViewById(R.id.password_edittext_login)
        login_button_login = findViewById(R.id.login_button_login)
        back_to_register_textview = findViewById(R.id.back_to_register_textview)
    }
}
