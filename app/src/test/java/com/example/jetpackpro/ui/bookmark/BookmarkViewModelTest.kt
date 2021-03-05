package com.example.jetpackpro.ui.bookmark

import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var bookmarkViewModel: BookmarkViewModel


    @Mock
    private lateinit var academyRepository: AcademyRepository


    @Before
    fun setUp() {
        bookmarkViewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmars() {
        // mock the repository
        `when`(academyRepository.getBookmarkedCourses()).thenReturn(DataDummy.generateDummyCourses() as ArrayList<CourseEntity>?)
        val courseEntities = bookmarkViewModel.getBookmars()

        //verify that function getbookmarkedcourse has been called
        verify(academyRepository).getBookmarkedCourses()


        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}