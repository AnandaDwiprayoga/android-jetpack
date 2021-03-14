package com.example.jetpackpro.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<Note>)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @RawQuery(observedEntities = [Note::class])
    fun getAllNotes(query: SupportSQLiteQuery): DataSource.Factory<Int, Note>
}