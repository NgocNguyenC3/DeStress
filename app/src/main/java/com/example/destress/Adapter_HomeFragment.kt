package com.example.destress

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView

class Adapter_HomeFragment(var context: Context, var arrayUsers: ArrayList<Post>) : BaseAdapter() {
    lateinit var imgChat_post: ImageButton
    lateinit var txtStatus_post: TextView
    lateinit var imgCmt_post: ImageButton
    lateinit var imgReact_post:ImageButton
    lateinit var imgBlock_post: ImageButton
    lateinit var txtUser_post: TextView


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.post,parent, false)
        addControls(view)
        addEvents(position, view)
        return view
    }

    private fun addEvents(position: Int, view: View) {
        txtStatus_post.text = arrayUsers[position].content
        txtUser_post.text = arrayUsers[position].author
        imgChat_post.setOnClickListener {
            chat(view, position)
        }

        imgCmt_post.setOnClickListener {
            cmt(view, position)
        }

        imgBlock_post.setOnClickListener {

        }
        imgReact_post.setOnClickListener {

        }
    }

    private fun cmt(view: View, position: Int) {
        var intent: Intent = Intent(view.context, CommentActivity::class.java)
        intent.putExtra("NameUser", arrayUsers[position].author)
        view.context.startActivity(intent)
    }

    private fun chat(view: View, position: Int) {
        var intent: Intent = Intent(view.context, ChatActivity::class.java)
        intent.putExtra("NameUser", arrayUsers[position].author)
        view.context.startActivity(intent)
    }

    private fun addControls(view: View) {
        txtUser_post = view.findViewById(R.id.txtUser_post)
        imgChat_post = view.findViewById(R.id.imgChat_post)
        txtStatus_post = view.findViewById(R.id.txtStatus_post)
        imgCmt_post = view.findViewById(R.id.imgCmt_post)
        imgReact_post = view.findViewById(R.id.imgReact_post)
        imgBlock_post = view.findViewById(R.id.imgBlock_post)
    }

    override fun getItem(position: Int): Any {
        return arrayUsers.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayUsers.size
    }
}