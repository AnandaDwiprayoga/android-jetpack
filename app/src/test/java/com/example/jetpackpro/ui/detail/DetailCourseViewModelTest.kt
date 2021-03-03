package com.example.jetpackpro.ui.detail

import com.example.jetpackpro.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailCourseViewModelTest {
    private lateinit var viewModel :DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun getCourse() {
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    @Test
    fun getModules() {
        val moduleEntity = viewModel.getModules()
        assertNotNull(moduleEntity)
        assertEquals(7, moduleEntity.size.toLong())
    }
}