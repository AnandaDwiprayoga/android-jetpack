package com.example.jetpackpro.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.jetpackpro.database.Note
import com.example.jetpackpro.database.NoteDao
import com.example.jetpackpro.database.NoteDatabase
import com.example.jetpackpro.helper.SortUtils
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    fun getAllNotes(sort: String): DataSource.Factory<Int, Note>{
        val query = SortUtils.getSortedQuery(sort)
        return mNotesDao.getAllNotes(query)
    }

    fun insert(note:Note) {
        executorService.execute {
            mNotesDao.insert(note)
        }
    }

    fun delete(note: Note){
        executorService.execute {
            mNotesDao.delete(note)
        }
    }

    fun update(note: Note){
        executorService.execute {
            mNotesDao.update(note)
        }
    }

}