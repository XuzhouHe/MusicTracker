package com.example.cse438.cse438_assignment2.data

data class ChartTracks(
    val id: Int,
    val title: String,
    val title_short: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val position: Int,
    val artist: ChartArtist,
    val album: ChartAlbum,
    val type: String
)

data class ChartData(
    val data: List<ChartTracks>
)

data class ChartPayload(
    val tracks: ChartData
)
