package com.example.cse438.cse438_assignment2.data

data class Tracks(

    val id: String,
    val title: String,
    val duration: String,
    val track_position : Int,
    val rank: String,
    val release_date: String,
    val gain: Double,
    val artist: ChartArtist,
    val album: ChartAlbum,
    val type: String

)



