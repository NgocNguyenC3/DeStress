package com.example.destress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class CommentActivity : AppCompatActivity() {
    lateinit var btnBack_activity_comment: ImageButton
    lateinit var txtNameUser_activity_comment: TextView
    lateinit var txtChatTalk_activity_comment: EditText
    lateinit var imgSend_activity_comment: ImageButton
    lateinit var lv_activity_comment: ListView
    var arrayUsersComment: ArrayList<UsersComment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        addControls()
        intent = getIntent()
        addEvents(intent)
    }

    private fun addEvents(intent: Intent?) {
        txtNameUser_activity_comment.text = intent?.getStringExtra("NameUser").toString()

        arrayUsersComment.add(UsersComment("1", "Alo alo"))
        lv_activity_comment.adapter = Adapter_Cmt(this, arrayUsersComment)

        imgSend_activity_comment.setOnClickListener {
            arrayUsersComment.add(UsersComment("5", txtChatTalk_activity_comment.text.toString()))
            lv_activity_comment.adapter = Adapter_Cmt(this, arrayUsersComment)
        }

        btnBack_activity_comment.setOnClickListener {
            finish()
        }
    }

    private fun addControls() {
        btnBack_activity_comment = findViewById(R.id.btnBack_activity_comment)
        txtNameUser_activity_comment = findViewById(R.id.txtNameUser_activity_comment)
        txtChatTalk_activity_comment = findViewById(R.id.txtChatTalk_activity_comment)
        imgSend_activity_comment = findViewById(R.id.imgSend_activity_comment)
        lv_activity_comment = findViewById(R.id.lv_activity_comment)
    }
}