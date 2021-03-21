package com.example.destress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.destress.adapter.ItemAdapter
import com.example.destress.data.Datasource
import com.example.destress.model.ImageListView

class PictureActivity : AppCompatActivity() {
    lateinit var lv_picture_activity: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        addControls()
        intent = getIntent()
        addEvents()
    }

    private fun addEvents() {
        lv_picture_activity.adapter = ImageListView(this, Datasource().loadAffirmations())


    }

    private fun addControls() {
        lv_picture_activity = findViewById(R.id.lv_picture_activity)
    }
}