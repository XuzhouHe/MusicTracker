package com.example.cse438.cse438_assignment2.network

import com.example.cse438.cse438_assignment2.data.ChartData
import com.example.cse438.cse438_assignment2.data.ChartPayload
import com.example.cse438.cse438_assignment2.data.ChartTracks
import com.example.cse438.cse438_assignment2.data.Tracks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeezerInterface {
    //api calls we want to make
    @GET("chart/0")
    suspend fun getChartTracks(): Response<ChartPayload>

    @GET("track/{id}")
    suspend fun getTracks(@Path("id") id: String): Response<Tracks>

    @GET("search")
    suspend fun searchTrack(@Query("q") q: String): Response<ChartData>

}