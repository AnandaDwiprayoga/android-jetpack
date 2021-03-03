package com.example.jetpackpro.ui.reader

import androidx.lifecycle.ViewModel
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.ContentEntity
import com.example.jetpackpro.data.ModuleEntity
import com.example.jetpackpro.utils.DataDummy

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): ArrayList<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId) as ArrayList<ModuleEntity>

    fun getSelectedModule(): ModuleEntity = academyRepository.getContent(courseId, moduleId)
}