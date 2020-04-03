package com.example.cse438.cse438_assignment2.data

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "track_table")
data class PlaylistTrack(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "artist")
    val artist: String,


    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "rate")
    val rate : String,

    @ColumnInfo(name = "playlist")
    val playlist: String


)

{
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}