package org.ui

interface MediumSystemInterface {
    fun addComment(noteId: String, authorId: String, comment: DraftComment)
    fun addNote(authorId: String, draftNote: DraftNote)
    fun editNote(noteId: String, draftNote: DraftNote)
    fun getAuthor(authorId: String): Author
    fun getNote(noteId: String): Note
    fun latestAddedNotes(): List<Note>
    fun login(email: String, password: String): Author
    fun registerAuthor(name: String, email: String, password: String, photo: String): Author
    fun removeNote(noteId: String)
    fun searchNotesByAuthorId(authorId: String): List<Note>
    fun searchNotesByCategory(category: String): List<Note>
    fun searchNotesByTitle(title: String): List<Note>
}

class MediumSystem(
    val authors: MutableList<Author> = mutableListOf(),
    val notes: MutableList<Note> = mutableListOf(),
    private val idGenerator: IdGenerator = IdGenerator()
) : MediumSystemInterface {

    override fun getNote(noteId: String): Note = notes.find { it.id == noteId } ?: throw NotFound("Note")

    override fun getAuthor(authorId: String): Author = authors.find { it.id == authorId } ?: throw NotFound("Author")

    override fun registerAuthor(name: String, email: String, password: String, photo: String): Author {
        existUserWithEmail(email)
        val author = Author(idGenerator.nextAuthorId(), name, email, password, photo)
        authors.add(author)
        return author
    }

    override fun login(email: String, password: String): Author {
        return authors.find { it.email == email && it.password == password } ?: throw NotFound("User")
    }

    override fun addNote(authorId: String, draftNote: DraftNote) {
        val author = getAuthor(authorId)
        existNoteWithSameTitle(authorId, draftNote.title)
        val categories = formatCategories(draftNote.categories)
        notes.add(Note(idGenerator.nextNoteId(), draftNote.title, draftNote.body, categories, author))
    }

    override fun editNote(noteId: String, draftNote: DraftNote) {
        val note = getNote(noteId)
        note.title = draftNote.title
        note.body = draftNote.body
        note.categories = formatCategories(draftNote.categories)
    }

    override fun removeNote(noteId: String) {
        notes.removeIf { it.id == noteId }
    }

    override fun addComment(noteId: String, authorId: String, comment: DraftComment) {
        val note = getNote(noteId)
        val author = getAuthor(authorId)
        note.comments.add(Comment(idGenerator.nextCommentId(), author, comment.body))
    }

    override fun searchNotesByAuthorId(authorId: String) = notes.filter { it.author.id == authorId }

    override fun searchNotesByCategory(category: String) = notes.filter { it.categories.contains(category) }

    override fun searchNotesByTitle(title: String) = notes.filter { it.title.contains(title, true) }

    override fun latestAddedNotes(): List<Note> = notes.takeLast(10)

    private fun existUserWithEmail(email: String) {
        if (authors.any { it.email == email }) throw UsedEmail()
    }

    private fun existNoteWithSameTitle(authorId: String, title: String) {
        if (notes.any { it.author.id == authorId && it.title == title }) throw RepeatedTitle()
    }

    private fun formatCategories(categories: String): List<String> {
        return categories.split(", ")
    }
}
