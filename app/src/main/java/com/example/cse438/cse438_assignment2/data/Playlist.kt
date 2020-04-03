package com.example.cse438.cse438_assignment2.data

import androidx.annotation.VisibleForTesting
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "playlist_table")
data class Playlist(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "desription")
    val desription: String,

    @ColumnInfo(name = "genre")

    val genre: String,
    @ColumnInfo(name = "rating")

    val rating: Int

)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}




