package com.example.jetpackpro.ui.academy

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.utils.DataDummy

class AcademyViewModel : ViewModel() {
    fun getCourses() : List<CourseEntity> = DataDummy.generateDummyCourses()

}