package com.example.jetpackpro.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.data.CourseWithModule
import com.example.jetpackpro.data.ModuleEntity
import com.example.jetpackpro.utils.DataDummy
import com.example.jetpackpro.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCourseViewModelTest {
    private lateinit var viewModel :DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId
    private val dummyModules = DataDummy.generateDummyModules(courseId)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Mock
    private lateinit var observer: Observer<Resource<CourseWithModule>>


    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun getCourseWithModule() {
        val dummyCourseWithModule = Resource.success(DataDummy.generateDummyCourseWithModules(dummyCourse, true))
        val course = MutableLiveData<Resource<CourseWithModule>>()
        course.value = dummyCourseWithModule
        `when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)
        viewModel.courseModule.observeForever(observer)
        verify(observer).onChanged(dummyCourseWithModule)
    }
}