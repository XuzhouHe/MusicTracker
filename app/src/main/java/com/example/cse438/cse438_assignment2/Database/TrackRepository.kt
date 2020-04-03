package com.example.cse438.cse438_assignment2.Database

import androidx.lifecycle.LiveData
import com.example.cse438.cse438_assignment2.data.Playlist
import com.example.cse438.cse438_assignment2.data.PlaylistTrack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class TrackRepository(public val trackDao: TrackDao){

    val alltracklist : LiveData<List<PlaylistTrack>> = trackDao.getalltrack()
    //val playlist: String = " "


    //need a insert function


    fun insert(track: PlaylistTrack) {
        CoroutineScope(Dispatchers.IO).launch {
            trackDao.insert(track)
        }
    }

    fun getalltracksbyplaylist(playlist: String): LiveData<List<PlaylistTrack>> {
        println(playlist.toString() + " is playlist passed in!!!!!!!!!!!!!!!!!!!!!!!")
        return trackDao.getAllSongsByPlaylist(playlist)

    }




    fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            trackDao.deleteAll()
        }
    }


}