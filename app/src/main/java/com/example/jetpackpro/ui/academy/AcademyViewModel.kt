package com.example.jetpackpro.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getCourses() : LiveData<List<CourseEntity>> = academyRepository.getAllCourses()

}