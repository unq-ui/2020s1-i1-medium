package org.ui

class IdGenerator {
    private var authorId = 0
    private var noteId = 0
    private var commentId = 0

    fun nextAuthorId(): String = "a_${++authorId}"
    fun nextNoteId(): String = "n_${++noteId}"
    fun nextCommentId(): String = "c_${++commentId}"
}
