package com.example.jetpackpro.ui.bookmark

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class BookmarkViewModelTest {

    private lateinit var bookmarkViewModel: BookmarkViewModel

    @Before
    fun setUp() {
        bookmarkViewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmars() {
        val courseEntities = bookmarkViewModel.getBookmars()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}