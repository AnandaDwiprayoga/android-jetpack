package com.example.jetpackpro.ui.academy

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setUp() {
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourses() {
        val courseEntity = viewModel.getCourses()
        assertNotNull(courseEntity)
        assertEquals(courseEntity.size, 5)
    }
}