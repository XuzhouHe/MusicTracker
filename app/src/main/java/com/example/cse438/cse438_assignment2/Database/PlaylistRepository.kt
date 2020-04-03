package com.example.cse438.cse438_assignment2.Database

import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.data.Playlist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class PlaylistRepository(public val playlistDao: PlaylistDao){

    val allPlaylist : LiveData<List<Playlist>> = playlistDao.getplaylist()

    //need a insert function

    fun insert(playlist: Playlist) {
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao.insert(playlist)
        }
    }

    fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            playlistDao.deleteAll()
        }
    }


}