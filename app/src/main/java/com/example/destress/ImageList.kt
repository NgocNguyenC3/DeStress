//package com.example.destress
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
//import com.example.destress.adapter.ItemAdapter
//import com.example.destress.data.Datasource
//
//class ImageList: AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        // Initialize data.
//        intent = getIntent()
//        val myDataset = Datasource().loadAffirmations()
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.adapter = ItemAdapter(this, myDataset)
//        //improve performance
//        recyclerView.setHasFixedSize(true)
//    }
//}