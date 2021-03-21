package com.example.destress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.destress.R

class MainActivity : AppCompatActivity() {
    lateinit var imgHome_activity_main: ImageButton
    lateinit var imgChat_activity_main: ImageButton
    lateinit var imgHotlin_activity_main: ImageButton
    lateinit var imgUsers_activity_main: ImageButton
    lateinit var frlayout_activity_main: FrameLayout
    var username : String = ""
    var password : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addControls()
        intent = getIntent()
        username = intent.getStringExtra("username").toString()
        password = intent.getStringExtra("password").toString()

        addEvents()
    }

    private fun addEvents() {
        imgHome_activity_main.setOnClickListener {
            Home(username, password)
        }

        imgChat_activity_main.setOnClickListener {
            Chat(username, password)
        }

        imgHotlin_activity_main.setOnClickListener {
            Hotline()
        }

        imgUsers_activity_main.setOnClickListener {

        }
    }

    private fun Hotline() {
        var fragmentManager: android.app.FragmentManager? = getFragmentManager()
        var fragmentTrans: android.app.FragmentTransaction? = fragmentManager?.beginTransaction()
        var fragmentHotline: HotlineFragment = HotlineFragment()
        fragmentTrans?.replace(R.id.frlayout_activity_main, fragmentHotline)
        fragmentTrans?.commit()
    }

    private fun Chat(username: String, password: String) {
        var fragmentManager : android.app.FragmentManager? = getFragmentManager()
        var fragmentTrans : android.app.FragmentTransaction? = fragmentManager?.beginTransaction()

        var fragmentChat: ChatFragment = ChatFragment.getInstance()
        var bundle: Bundle = Bundle()
        bundle.putString("username", username)
        bundle.putString("password", password)
        fragmentChat.arguments = bundle

        fragmentTrans?.replace(R.id.frlayout_activity_main, fragmentChat)
        fragmentTrans?.commit()
    }

    private fun Home(username: String, password: String) {
        var fragmentManager : android.app.FragmentManager? = getFragmentManager()
        var fragmentTrans : android.app.FragmentTransaction? = fragmentManager?.beginTransaction()

        var fragmentHome: HomeFragment = HomeFragment.getInstance()

        var bundle: Bundle = Bundle()
        bundle.putString("username", username)
        bundle.putString("password", password)
        fragmentHome.arguments = bundle
        fragmentTrans?.replace(R.id.frlayout_activity_main, fragmentHome)
        fragmentTrans?.commit()

    }

    private fun addControls() {
        imgChat_activity_main = findViewById(R.id.imgChat_activity_main)
        imgHome_activity_main = findViewById(R.id.imgHome_activity_main)
        imgHotlin_activity_main = findViewById(R.id.imgHotlin_activity_main)
        imgUsers_activity_main = findViewById(R.id.imgUsers_activity_main)
        frlayout_activity_main = findViewById(R.id.frlayout_activity_main)
    }
}