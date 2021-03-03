package com.example.jetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.data.ModuleEntity
import com.example.jetpackpro.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String){
        this.courseId = courseId
    }

    fun getCourse() : CourseEntity = academyRepository.getCourseWithModules(courseId)


    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}