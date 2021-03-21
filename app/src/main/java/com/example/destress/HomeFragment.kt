package com.example.destress

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ListView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import org.json.JSONObject
import com.beust.klaxon.Klaxon

class HomeFragment :android.app.Fragment() {
    lateinit var lv_home_fragment: ListView
    lateinit var btnAdd_home_fragment: ImageButton
    var arrayPosts: ArrayList<Post> = ArrayList()
    lateinit var contect: Context
    var username : String = ""
    var password : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.home_fragment, container, false)

        username = arguments.getString("username").toString()
        password = arguments.getString("password").toString()
        loadPost_fallback()

//        arrayUsers.add(Users("1", "Hello everyone"))
//        arrayUsers.add(Users("2", "What a beautiful day"))
//        arrayUsers.add(Users("3", "Bad Day"))
//        arrayUsers.add(Users("4", "........."))
        lv_home_fragment = view.findViewById(R.id.lv_home_fragment)
        btnAdd_home_fragment = view.findViewById(R.id.btnAdd_home_fragment)
        lv_home_fragment.adapter = Adapter_HomeFragment(view.context, arrayPosts)
        contect = view.context

        btnAdd_home_fragment.setOnClickListener {
            Events(view)
        }
        return view
    }

    fun loadPosts() {
        var jsonbody = mapOf<String, String>("username" to username, "password" to password, "type" to "0", "topic" to "")
        var resp_body : String = ""
        var response_code = 0

        Fuel.post("http://10.0.2.2:8000/getposts")
            .jsonBody(JSONObject(jsonbody).toString())
            .response { request, response, result ->
                kotlin.run {
                    Log.d("GET POST STATUS CODE", response.statusCode.toString())
                    response_code = response.statusCode
                    Log.d("LOAD POSTS", result.get().toString())

                }
            }
        //        var body = Klaxon().parseArray<Post>(resp_body)
//        body?.iterator()?.forEach {
//            arrayPosts.add(it)
//        }
    }

    fun loadPost_fallback() {
        var cmt1 = Comment(1,"acbu1234", "Yeah, debugging it is really a pain")
        var cmt2 = Comment(2,"david098", "You will be alright! Don't ever give up!")
        var cmt3 = Comment(3,"jeremy87", "Wish you the best!")

        var cmt4 = Comment(1,"akjsh123", "Yam tincidunt cursus neque, vitae dapibus turpis varius id. Vestibulum interdum tincidunt est.")
        var cmt5 = Comment(2,"aslka556", "Morbi quis iaculis libero. Etiam ac risus sit amet diam imperdiet venenatis vitae a lorem. In in risus eu leo pretium porta.")
        var cmt6 = Comment(3,"jjiuy899", "Nulla blandit arcu enim, in ornare justo tristique vitae. Donec sodales semper nibh, nec laoreet lorem convallis et")

        var post1 = Post(1, "I am suffering from writing this application.", listOf(cmt1, cmt2, cmt3), "administrator")
        var post2 = Post(2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut blandit purus a nibh tincidunt laoreet.", listOf(cmt4, cmt5, cmt6), "another")

        arrayPosts.add(post1)
        arrayPosts.add(post2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 33)
        //arrayUsers.add(Post("1", data?.getStringExtra("status").toString()))
        lv_home_fragment.adapter = Adapter_HomeFragment(contect, arrayPosts)
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