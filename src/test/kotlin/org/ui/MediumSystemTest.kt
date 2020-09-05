package org.ui

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MediumSystemTest {

    @Test
    fun registerAuthor() {
        val mediumSystem = MediumSystem()
        assertEquals(mediumSystem.authors.size, 0)
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.authors.size, 1)
        assertEquals(mediumSystem.authors[0].email, "juan@gmail.com")
        assertEquals(mediumSystem.authors[0].name, "Juan")
    }

    @Test
    fun registerAuthorTwoTimes() {
        val mediumSystem = MediumSystem()
        assertEquals(mediumSystem.authors.size, 0)
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.authors.size, 1)
        assertFailsWith(UsedEmail::class) {
            mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        }
    }

    @Test
    fun login() {
        val mediumSystem = MediumSystem()
        assertEquals(mediumSystem.authors.size, 0)
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.authors.size, 1)
        val user = mediumSystem.login("juan@gmail.com", "juan")
        assertEquals(user.email, "juan@gmail.com")
        assertEquals(user.name, "Juan")
    }

    @Test
    fun loginWithoutUsers() {
        val mediumSystem = MediumSystem()
        assertFailsWith(NotFound::class) {
            mediumSystem.login("juan@gmail.com", "juan")
        }
    }

    @Test
    fun loginWithWrongPassword() {
        val mediumSystem = MediumSystem()
        assertEquals(mediumSystem.authors.size, 0)
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.authors.size, 1)
        assertFailsWith(NotFound::class) {
            mediumSystem.login("juan@gmail.com", "juan2")
        }
    }

    @Test
    fun loginWithWrongEmail() {
        val mediumSystem = MediumSystem()
        assertEquals(mediumSystem.authors.size, 0)
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.authors.size, 1)
        assertFailsWith(NotFound::class) {
            mediumSystem.login("juan2@gmail.com", "juan")
        }
    }

    @Test
    fun addNote() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.notes.size, 0)
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertEquals(mediumSystem.notes.size, 1)
        val note = mediumSystem.notes[0]
        assertEquals(note.id, "n_1")
        assertEquals(note.title, "Note1")
        assertEquals(note.body, "Body1")
        assertEquals(note.categories.size, 2)
    }

    @Test
    fun addNoteTwoTimes() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.notes.size, 0)
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertEquals(mediumSystem.notes.size, 1)
        assertFailsWith<RepeatedTitle> {
            mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        }
    }

    @Test
    fun addNoteTwoTimesToDifferentAuthors() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.registerAuthor("Lean", "lean@gmail.com", "lean", "https://img.icons8.com/bubbles/2x/user.png")
        assertEquals(mediumSystem.notes.size, 0)
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        mediumSystem.addNote("a_2", DraftNote("Note1", "Body1", "test, test2"))
        assertEquals(mediumSystem.notes.size, 2)
    }

    @Test
    fun addNoteWithNotExistingAuthor() {
        val mediumSystem = MediumSystem()
        assertEquals(mediumSystem.notes.size, 0)
        assertFailsWith<NotFound> {
            mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        }
    }

    @Test
    fun editNote() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertEquals(mediumSystem.notes.size, 1)
        mediumSystem.editNote("n_1", DraftNote("EditTitle", "EditBody", "EditCategories"))
        val note = mediumSystem.notes[0]
        assertEquals(note.id, "n_1")
        assertEquals(note.title, "EditTitle")
        assertEquals(note.body, "EditBody")
        assertEquals(note.categories.size, 1)
    }

    @Test
    fun editNoteWithNotExistingId() {
        val mediumSystem = MediumSystem()
        assertFailsWith<NotFound> {
            mediumSystem.editNote("n_1", DraftNote("EditTitle", "EditBody", "EditCategories"))
        }
    }

    @Test
    fun removeNote() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertEquals(mediumSystem.notes.size, 1)
        mediumSystem.removeNote("n_1")
        assertEquals(mediumSystem.notes.size, 0)
    }

    @Test
    fun removeNoteWithWrongId() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertEquals(mediumSystem.notes.size, 1)
        mediumSystem.removeNote("n_2")
        assertEquals(mediumSystem.notes.size, 1)
    }

    @Test
    fun addComment() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        mediumSystem.addComment("n_1", "a_1", DraftComment("Comment1"))
        val note = mediumSystem.getNote("n_1")
        assertEquals(note.title, "Note1")
        assertEquals(note.comments.size, 1)
        assertEquals(note.comments[0].body, "Comment1")
        assertEquals(note.comments[0].author.id, "a_1")
    }

    @Test
    fun addCommentWithWrongAuthorId() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertFailsWith<NotFound> {
            mediumSystem.addComment("n_1", "a_2", DraftComment("Comment1"))
        }
    }

    @Test
    fun addCommentWithWrongNoteId() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))
        assertFailsWith<NotFound> {
            mediumSystem.addComment("n_2", "a_1", DraftComment("Comment1"))
        }
    }

    @Test
    fun searchNotesByAuthorId() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test, test2"))

        mediumSystem.registerAuthor("Lean", "lean@gmail.com", "lean", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_2", DraftNote("Note2", "Body2", "test, test2"))

        val notes = mediumSystem.searchNotesByAuthorId("a_1")

        assertEquals(notes.size, 1)
        assertEquals(notes[0].title, "Note1")
    }

    @Test
    fun searchNotesByCategory() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test"))

        mediumSystem.registerAuthor("Lean", "lean@gmail.com", "lean", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_2", DraftNote("Note2", "Body2", "test2"))

        val notes = mediumSystem.searchNotesByCategory("test")

        assertEquals(notes.size, 1)
        assertEquals(notes[0].title, "Note1")
    }

    @Test
    fun latestAddedNotes() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test"))

        mediumSystem.registerAuthor("Lean", "lean@gmail.com", "lean", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_2", DraftNote("Note2", "Body2", "test2"))

        val notes = mediumSystem.latestAddedNotes()

        assertEquals(notes.size, 2)
    }

    @Test
    fun searchNotesByTitle() {
        val mediumSystem = MediumSystem()
        mediumSystem.registerAuthor("Juan", "juan@gmail.com", "juan", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_1", DraftNote("Note1", "Body1", "test"))

        mediumSystem.registerAuthor("Lean", "lean@gmail.com", "lean", "https://img.icons8.com/bubbles/2x/user.png")
        mediumSystem.addNote("a_2", DraftNote("asd", "Body2", "test2"))

        val notes = mediumSystem.searchNotesByTitle("note")

        assertEquals(notes.size, 1)
        assertEquals(notes[0].title, "Note1")
    }
}
