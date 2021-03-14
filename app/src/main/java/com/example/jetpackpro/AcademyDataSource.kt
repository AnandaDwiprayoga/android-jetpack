package com.example.jetpackpro

import androidx.lifecycle.LiveData
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.data.CourseWithModule
import com.example.jetpackpro.data.ModuleEntity
import com.example.jetpackpro.vo.Resource

interface AcademyDataSource {

    fun getAllCourses(): LiveData<Resource<List<CourseEntity>>>

    fun getCourseWithModules(courseId: String): LiveData<Resource<CourseWithModule>>

    fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>>

    fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>>

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

    fun setCourseBookmark(course: CourseEntity, state: Boolean)

    fun setReadModule(module: ModuleEntity)
}