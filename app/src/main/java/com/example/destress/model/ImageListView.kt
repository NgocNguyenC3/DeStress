package com.example.destress.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.destress.R
import com.example.destress.UsersComment

class ImageListView(var context: Context, var arrayImage: List<Affirmation>): BaseAdapter() {
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        textView= view.findViewById(R.id.item_title)
        imageView= view.findViewById(R.id.item_image)

        events(view, position)
        return view
    }

    private fun events(view: View, position: Int) {
        textView.text = context.resources.getString(arrayImage[position].stringResourceId)
        imageView.setImageResource(arrayImage[position].imageResourceId)
    }

    override fun getItem(position: Int): Any {
        return arrayImage.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayImage.size
    }

}