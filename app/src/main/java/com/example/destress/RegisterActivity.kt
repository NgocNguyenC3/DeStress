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
import org.json.JSONObject


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
        register_button_register.setOnClickListener {
            var username = username_edittext_register.text.toString()
            var password = password_edittext_register.text.toString()

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
        var jsonbody = mapOf<String, String>("username" to username, "password" to password, "type" to "0")

        Fuel.post("http://10.0.2.2:8000/register")
                .jsonBody(JSONObject(jsonbody).toString())
                .response { request, response, result ->
                    kotlin.run {
                        Log.d("REGISTER STATUS CODE", response.statusCode.toString())
                        succ = response.statusCode == 201
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