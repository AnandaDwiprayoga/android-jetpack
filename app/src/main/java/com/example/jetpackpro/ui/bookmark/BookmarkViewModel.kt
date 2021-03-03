package com.example.jetpackpro.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.utils.DataDummy

class BookmarkViewModel : ViewModel(){
    fun getBookmars() : List<CourseEntity> = DataDummy.generateDummyCourses()
}