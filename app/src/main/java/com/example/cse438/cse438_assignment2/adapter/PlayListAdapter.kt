package com.example.cse438.cse438_assignment2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.ShowTracks
import com.example.cse438.cse438_assignment2.TrackInfo
import com.example.cse438.cse438_assignment2.data.ChartTracks
import com.example.cse438.cse438_assignment2.data.Playlist
import com.squareup.picasso.Picasso

class PlayListAdapter (private val list : ArrayList<Playlist>) : RecyclerView.Adapter<PlayListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlayListViewHolder(inflater, parent)

    }


    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        val playlist: Playlist = list[position]
        holder.bind(playlist)
    }

    override fun getItemCount(): Int = list.size
}

class PlayListViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.playlist_layout, parent,false)){
    private val playlist_title : TextView
    private val playlist_des : TextView

    init {
        playlist_title = itemView.findViewById(R.id.playlist_title)
        playlist_des = itemView.findViewById(R.id.playlist_desc)
    }

    fun bind(playlist: Playlist){

        playlist_title.text = playlist.title
        playlist_des.text = playlist.desription
        playlist_title.setOnClickListener {
            val intent = Intent(playlist_title.context, ShowTracks::class.java)
            intent.putExtra("name",playlist.title)
            ContextCompat.startActivity(playlist_title.context, intent, null)
        }

    }
}