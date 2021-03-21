package com.example.destress

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter_Cmt(var context: Context, var arrayUsersComment: ArrayList<UsersComment>) : BaseAdapter() {
    lateinit var txtUserName_comment_user: TextView
    lateinit var txtCmt_comment_user: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.comment_user,parent, false)
        addControls(view)
        addEvents(position, view)
        return view
    }

    private fun addEvents(position: Int, view: View) {
        txtUserName_comment_user.text = arrayUsersComment.get(position).name
        txtCmt_comment_user.text = arrayUsersComment.get(position).cmt
    }

    private fun addControls(view: View) {
        txtCmt_comment_user = view.findViewById(R.id.txtCmt_comment_user)
        txtUserName_comment_user = view.findViewById(R.id.txtUserName_comment_user)
    }

    override fun notifyDataSetChanged() {

    }
    override fun getItem(position: Int): Any {
        return arrayUsersComment.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayUsersComment.size
    }
}