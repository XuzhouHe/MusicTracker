package com.example.cse438.cse438_assignment2.network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.ChartData
import com.example.cse438.cse438_assignment2.data.ChartPayload
import com.example.cse438.cse438_assignment2.data.ChartTracks
import com.example.cse438.cse438_assignment2.data.Tracks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class DeezerRepository {
    val service = ApiClient.makeRetrofitService()

    fun getChartTracks(resBody: MutableLiveData<ChartPayload>){
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getChartTracks()
            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }

    fun getTracks(resBody: MutableLiveData<Tracks>, Id: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getTracks(Id)
            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }

    fun searchTracks(resBody: MutableLiveData<ChartData>, keyword: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.searchTrack(keyword)
            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }

    fun searchTrack(resBody: MutableLiveData<ChartData>, keyword: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.searchTrack(keyword)
            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }

}