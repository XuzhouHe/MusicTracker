package com.example.cse438.cse438_assignment2.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cse438.cse438_assignment2.data.Playlist
import com.example.cse438.cse438_assignment2.data.PlaylistTrack

@Dao
interface TrackDao {

    @Query("SELECT * FROM track_table")
    fun getalltrack(): LiveData<List<PlaylistTrack>>

    @Insert
    fun insert(track: PlaylistTrack)

    @Query("DELETE FROM track_table")
    fun deleteAll()

    @Query("SELECT * FROM track_table WHERE track_table.playlist=:playlist")
    fun getAllSongsByPlaylist(playlist: String): LiveData<List<PlaylistTrack>>

    @Delete()
    fun delete(track: PlaylistTrack)

    //delete a single item from the playlist
}