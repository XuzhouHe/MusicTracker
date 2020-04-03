package com.example.cse438.cse438_assignment2.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.ChartData
import com.example.cse438.cse438_assignment2.data.ChartPayload
import com.example.cse438.cse438_assignment2.data.ChartTracks
import com.example.cse438.cse438_assignment2.data.Tracks
import com.example.cse438.cse438_assignment2.network.DeezerRepository

class TrackViewModel (application: Application): AndroidViewModel(application){

    public var trackList: MutableLiveData<ChartPayload> = MutableLiveData()
    public var track: MutableLiveData<Tracks> = MutableLiveData()

    public var searchList: MutableLiveData<ChartData> = MutableLiveData()

    public var deezerRepository : DeezerRepository = DeezerRepository()

    fun getChartTracks(){
        deezerRepository.getChartTracks(trackList)
    }

    fun getTracks(Id: String){
        deezerRepository.getTracks(track,Id)
    }

    fun searchTracks(keyword: String){


        deezerRepository.searchTracks(searchList, keyword)
    }



}
