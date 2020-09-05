package org.ui

data class DraftNote(
    var title: String,
    var body: String,
    var categories: String
)

data class Note(
    val id: String,
    var title: String,
    var body: String,
    var categories: List<String>,
    val author: Author,
    val comments: MutableList<Comment> = mutableListOf()
)

data class Author(
    val id: String,
    val name: String,
    val email: String,
    var password: String,
    var photo: String
)

data class Comment(
    val id: String,
    val author: Author,
    val body: String
)

data class DraftComment(val body: String)
