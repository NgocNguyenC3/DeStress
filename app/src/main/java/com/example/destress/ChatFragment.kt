package com.example.destress

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class ChatFragment: android.app.Fragment() {
    lateinit var btnPro_chat_fragment: Button
    lateinit var btnVolunteer_chat_fragment: Button
    lateinit var btnAnotherUser_chat_fragment: Button
    lateinit var txtUser_chat_fragment: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.chat_fragment, container, false)
        addControls(view)
        addEvents(view)
        return view
    }

    private fun addEvents(view: View) {
        btnPro_chat_fragment.setOnClickListener {
            ProContact(view)
        }

        btnVolunteer_chat_fragment.setOnClickListener {
            Volunteer_Contact(view)
        }

        btnAnotherUser_chat_fragment.setOnClickListener {
            User_Contact(view)
        }
    }

    private fun User_Contact(view: View) {
        var intent: Intent = Intent(view.context, ChatActivity::class.java)
        intent.putExtra("NameUser", txtUser_chat_fragment.text.toString())
        view.context.startActivity(intent)
    }

    private fun Volunteer_Contact(view:View) {
        var intent: Intent = Intent(view.context, ChatActivity::class.java)
        intent.putExtra("NameUser", "Hello")
        view.context.startActivity(intent)
    }

    private fun ProContact(view: View) {
        var intent: Intent = Intent(view.context, ChatActivity::class.java)
        intent.putExtra("NameUser", "john")
        view.context.startActivity(intent)
    }

    private fun addControls(view: View) {
        btnPro_chat_fragment = view.findViewById(R.id.btnPro_chat_fragment)
        btnVolunteer_chat_fragment = view.findViewById(R.id.btnVolunteer_chat_fragment)
        btnAnotherUser_chat_fragment = view.findViewById(R.id.btnAnotherUser_chat_fragment)
        txtUser_chat_fragment = view.findViewById(R.id.txtUser_chat_fragment)
    }

    companion object {
        fun getInstance() : ChatFragment {
            return ChatFragment()
        }
    }
}