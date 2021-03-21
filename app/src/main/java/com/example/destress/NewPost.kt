package com.example.destress

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class NewPost : AppCompatActivity() {
    lateinit var txt_post_activity: EditText
    lateinit var btn_post_activity: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)
        intent = getIntent()
        addControls()
        addEvents(intent)

    }


    private fun addEvents(intent: Intent?) {

        btn_post_activity.setOnClickListener {
            intent?.putExtra("status", txt_post_activity.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


    private fun addControls() {

        btn_post_activity = findViewById(R.id.btn_post_activity)
        txt_post_activity = findViewById(R.id.txt_post_activity)
    }
}