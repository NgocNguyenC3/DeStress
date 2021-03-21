package com.example.destress

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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
            saveInfo()
            finish()
        }
        already_have_account_text_view.setOnClickListener {
            finish()
        }
    }

    private fun saveInfo() {

    }


    private fun addControls() {
        username_edittext_register = findViewById(R.id.username_edittext_register)
        register_button_register = findViewById(R.id.register_button_register)
        already_have_account_text_view = findViewById(R.id.already_have_account_text_view)
        password_edittext_register = findViewById(R.id.password_edittext_register)
    }

}