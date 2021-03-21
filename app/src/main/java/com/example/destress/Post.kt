package com.example.destress

import java.sql.Timestamp

class Comment(var id: Int, var username: String, var content: String)
class Post(var id: Int, var content: String, var comments: List<Comment>, var author: String)
