package com.example.jetpackpro.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel(){
    fun getBookmars() : List<CourseEntity> = academyRepository.getBookmarkedCourses()
}