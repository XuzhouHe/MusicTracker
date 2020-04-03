package com.example.cse438.cse438_assignment2.ViewModel

import com.example.cse438.cse438_assignment2.Database.TrackDataBase
import com.example.cse438.cse438_assignment2.Database.TrackRepository
import com.example.cse438.cse438_assignment2.data.PlaylistTrack

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Database.PlaylistDataBase
import com.example.cse438.cse438_assignment2.Database.PlaylistRepository
import com.example.cse438.cse438_assignment2.data.Playlist

public class PlaylistTrackViewModel(application:Application): AndroidViewModel(application){
    public var trackList : LiveData<List<PlaylistTrack>> = MutableLiveData()
    public val repository: TrackRepository
    public  var askedlist : LiveData<List<PlaylistTrack>> = MutableLiveData()


    init {
        repository = TrackRepository(TrackDataBase.getDatabase(application).trackDao() )
        trackList=repository.alltracklist
    }

    fun getalltracks():LiveData<List<PlaylistTrack>>{
        return trackList
    }

    fun getalltracksbyplaylist(playlist:String) : LiveData<List<PlaylistTrack>> {
        askedlist = repository.getalltracksbyplaylist(playlist)
        return  askedlist

    }

    fun insert(track: PlaylistTrack){
        repository.insert(track)
    }



    fun clear(){
        repository.clear()
    }

}