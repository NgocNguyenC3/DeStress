package com.example.destress


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView

class HotlineFragment: android.app.Fragment(){
    lateinit var lvHotline_fragment: ListView
    lateinit var btn_hotline_fragment: Button
    var arrayCustomerCare: ArrayList<CustomerCare> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.hotline_fargment, container, false)
        arrayCustomerCare.add(CustomerCare("Health Care Department", "0123456789"))
        arrayCustomerCare.add(CustomerCare("Therapist", "012343553"))
        arrayCustomerCare.add(CustomerCare("Family", "0123435533"))
        arrayCustomerCare.add(CustomerCare("Rosy", "01234355332"))
        addControls(view)
        lvHotline_fragment.adapter = Adapter_HotlineFragment(view.context, arrayCustomerCare)
        addEvents(view)
        btn_hotline_fragment.setOnClickListener{
            val intent = Intent(view.context,PictureActivity::class.java )
            view.context.startActivity(intent)
        }
        return view
    }

    private fun addEvents(view: View) {
        btn_hotline_fragment.setOnClickListener {
            hotline_fragment(view)
        }
    }

    private fun hotline_fragment(view: View) {
        var intent: Intent = Intent(view.context, PictureActivity::class.java)
        view.context.startActivity(intent)
    }

    private fun addControls(view: View) {
        lvHotline_fragment = view.findViewById(R.id.lvHotline_fragment)
        btn_hotline_fragment = view.findViewById(R.id.btn_hotline_fragment)

    }


    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}

