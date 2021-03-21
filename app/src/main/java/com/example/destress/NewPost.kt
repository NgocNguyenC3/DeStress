package com.example.destress

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import org.json.JSONObject

class NewPost : AppCompatActivity() {
    lateinit var txt_post_activity: EditText
    lateinit var btn_post_activity: Button

    var username : String = ""
    var password : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)
        intent = getIntent()
        addControls()
        addEvents(intent)

        username = intent?.getStringExtra("username").toString()
        password = intent?.getStringExtra("password").toString()
    }


    private fun addEvents(intent: Intent?) {

        btn_post_activity.setOnClickListener {
            intent?.putExtra("status", txt_post_activity.text.toString())

            var jsonbody = mapOf<String, String>("username" to username, "password" to password, "content" to txt_post_activity.text.toString(), "topic" to "Other")
            var succ = false

            Fuel.post("http://10.0.2.2:8000/newpost")
                .jsonBody(JSONObject(jsonbody).toString())
                .response { request, response, result ->
                    kotlin.run {
                        Log.d("NEW POST STATUS CODE", response.statusCode.toString())
                        succ = response.statusCode == 201
                    }
                }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


    private fun addControls() {

        btn_post_activity = findViewById(R.id.btn_post_activity)
        txt_post_activity = findViewById(R.id.txt_post_activity)
    }
}