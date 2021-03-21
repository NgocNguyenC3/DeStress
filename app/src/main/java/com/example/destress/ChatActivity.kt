package com.example.destress

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {
    lateinit var btnBack_acrivity_chat: ImageButton
    lateinit var txtNameUser_acrivity_chat: TextView
    lateinit var txtChatTalk_acrivity_chat: EditText
    lateinit var imgSend_acrivity_chat: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        addControls()
        intent = getIntent()
        addEvents(intent)
    }

    private fun addEvents(intent: Intent?) {
        txtNameUser_acrivity_chat.text = intent?.getStringExtra("NameUser").toString()

        btnBack_acrivity_chat.setOnClickListener {
            finish()
        }
    }

    private fun addControls() {
        btnBack_acrivity_chat = findViewById(R.id.btnBack_acrivity_chat)
        txtNameUser_acrivity_chat = findViewById(R.id.txtNameUser_acrivity_chat)
        txtChatTalk_acrivity_chat = findViewById(R.id.txtChatTalk_acrivity_chat)
        imgSend_acrivity_chat = findViewById(R.id.imgSend_acrivity_chat)
    }
}