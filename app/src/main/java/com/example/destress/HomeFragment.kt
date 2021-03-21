package com.example.destress

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment :android.app.Fragment() {
    lateinit var lv_home_fragment: ListView
    lateinit var btnAdd_home_fragment: ImageButton
    var arrayUsers: ArrayList<Users> = ArrayList()
    lateinit var contect: Context
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.home_fragment, container, false)
        arrayUsers.add(Users("1", "Hello everyone"))
        arrayUsers.add(Users("2", "What a beautiful day"))
        arrayUsers.add(Users("3", "Bad Day"))
        arrayUsers.add(Users("4", "........."))
        lv_home_fragment = view.findViewById(R.id.lv_home_fragment)
        btnAdd_home_fragment = view.findViewById(R.id.btnAdd_home_fragment)
        lv_home_fragment.adapter = Adapter_HomeFragment(view.context, arrayUsers)
        contect = view.context

        btnAdd_home_fragment.setOnClickListener {
            Events(view)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 33)
        arrayUsers.add(Users("1", data?.getStringExtra("status").toString()))
        lv_home_fragment.adapter = Adapter_HomeFragment(contect, arrayUsers)
    }

    private fun Events(view: View) {
        var intent: Intent = Intent(view.context, NewPost::class.java)
        startActivityForResult(intent, 33)

    }

    companion object {
        fun getInstance() : HomeFragment {
            return HomeFragment()
        }
    }
}