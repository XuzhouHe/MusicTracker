package com.example.cse438.cse438_assignment2.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cse438.cse438_assignment2.data.Playlist
import com.example.cse438.cse438_assignment2.data.Tracks

@Dao
interface PlaylistDao {

    @Query("SELECT * FROM playlist_table")
    fun getplaylist(): LiveData<List<Playlist>>

    @Insert
    fun insert(playlist: Playlist)

    @Query("DELETE FROM playlist_table")
    fun deleteAll()

    //delete a single item from the playlist


}