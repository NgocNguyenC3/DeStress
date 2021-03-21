package com.example.destress

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPatch
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result


class RegisterActivity: AppCompatActivity() {
    lateinit var username_edittext_register: EditText
    lateinit var password_edittext_register: EditText
    lateinit var register_button_register: Button
    lateinit var already_have_account_text_view: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        addControls()
        intent = getIntent()
        addEvents()
    }

    private fun addEvents() {
        var username = username_edittext_register.text.toString()
        var password = password_edittext_register.text.toString()

        register_button_register.setOnClickListener {
            if (saveInfo(username, password)) {
                Toast.makeText(this, "Register successfully!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Register failed!", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
        already_have_account_text_view.setOnClickListener {
            finish()
        }
    }

    private fun saveInfo(username: String, password: String) : Boolean {
        var succ: Boolean = false
        var jsonbody = String.format("{'username': '%s', 'password': '%s'}", username, password)
//        Fuel.get("http://google.com")
//                .jsonBody("")
//                .response { request, response, result ->
//                    kotlin.run {
//                        Log.d("REGISTER STATUS CODE", response.statusCode.toString())
//                        succ = response.statusCode == 200
//                    }
//                }
        Fuel.get("https://httpbin.org/get")
                .response { request, response, result ->
                    Log.d("REGISTER STATUS CODE", request.toString())
                    Log.d("REGISTER STATUS CODE", response.toString())

                    val (bytes, error) = result
                    if (bytes != null) {
                        Log.d("REGISTER STATUS CODE", String(bytes))
                    }
                }
        return succ
    }


    private fun addControls() {
        username_edittext_register = findViewById(R.id.username_edittext_register)
        register_button_register = findViewById(R.id.register_button_register)
        already_have_account_text_view = findViewById(R.id.already_have_account_text_view)
        password_edittext_register = findViewById(R.id.password_edittext_register)
    }

}