package com.example.destress

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView

class Adapter_HotlineFragment(var context: Context, var arrayCustomerCare:  ArrayList<CustomerCare>): BaseAdapter() {
    lateinit var imgUser_hotline_infor: ImageButton
    lateinit var txtInfor_hotline_infor: TextView
    lateinit var txtPhoneNumber_hotline_infor: TextView
    lateinit var imgCall_hotline_infor: ImageButton

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.hotline_infor,parent, false)
        addControls(view)
        addEvents(position, view)
        return view
    }

    private fun addEvents(position: Int, view: View) {
        txtInfor_hotline_infor.text = arrayCustomerCare[position].name
        txtPhoneNumber_hotline_infor.text = arrayCustomerCare[position].phoneNumber

        imgCall_hotline_infor.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_DIAL)
            var number: String = arrayCustomerCare[position].phoneNumber
            intent.data = Uri.parse("tel:$number")
            view.context.startActivity(intent)
        }
    }

    private fun addControls(view: View) {
        imgUser_hotline_infor = view.findViewById(R.id.imgCall_hotline_infor)
        txtInfor_hotline_infor = view.findViewById(R.id.txtInfor_hotline_infor)
        txtPhoneNumber_hotline_infor = view.findViewById(R.id.txtPhoneNumber_hotline_infor)
        imgCall_hotline_infor = view.findViewById(R.id.imgCall_hotline_infor)
    }

    override fun getItem(position: Int): Any {
        return arrayCustomerCare.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayCustomerCare.size
    }

}
