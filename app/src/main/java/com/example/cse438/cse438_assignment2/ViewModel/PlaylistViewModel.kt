package com.example.cse438.cse438_assignment2.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Database.PlaylistDataBase
import com.example.cse438.cse438_assignment2.Database.PlaylistRepository
import com.example.cse438.cse438_assignment2.data.Playlist

public class PlaylistViewModel(application:Application): AndroidViewModel(application){
    public var wholePlaylist : LiveData<List<Playlist>> = MutableLiveData()
    public val repository: PlaylistRepository
    init {
        repository = PlaylistRepository(PlaylistDataBase.getDatabase(application).playlistDao())
        wholePlaylist=repository.allPlaylist
    }

    fun getPlaylistLiveData():LiveData<List<Playlist>>{
        return wholePlaylist
    }

    fun insert(playlist: Playlist){
        repository.insert(playlist)
    }

    fun clear(){
        repository.clear()
    }

}