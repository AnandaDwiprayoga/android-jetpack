package com.example.jetpackpro.ui.di

import android.content.Context
import com.example.jetpackpro.AcademyDataSource
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AcademyRepository.getInstance(remoteDataSource)
    }
}