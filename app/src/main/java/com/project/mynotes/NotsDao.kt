package com.project.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //suspend to run these processes in background threads it is called coroutines.
    suspend fun insert(note:Notes)
    @Delete
    suspend fun delete(note: Notes)
    @Query("Select * from notes_table order by id ASC")
    //with the help of live data our observer in our case activity knows when there is changes occur database

    fun getAllNotes(): LiveData<List<Notes>>
}