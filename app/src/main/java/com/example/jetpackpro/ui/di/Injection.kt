package com.example.jetpackpro.ui.di

import android.content.Context
import com.example.jetpackpro.AcademyRepository
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.data.source.room.AcademyDatabase
import com.example.jetpackpro.data.source.room.LocalDataSource
import com.example.jetpackpro.utils.AppExecutors
import com.example.jetpackpro.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {
        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}