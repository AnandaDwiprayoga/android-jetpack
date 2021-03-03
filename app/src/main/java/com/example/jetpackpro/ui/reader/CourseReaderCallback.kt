package com.example.jetpackpro.ui.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}