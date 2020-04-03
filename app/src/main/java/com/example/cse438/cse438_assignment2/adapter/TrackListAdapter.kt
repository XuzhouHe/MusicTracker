package com.example.cse438.cse438_assignment2.adapter

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.cse438_assignment2.Fragment.HomeFragment
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.TrackInfo
import com.example.cse438.cse438_assignment2.data.ChartTracks
import com.example.cse438.cse438_assignment2.data.Tracks
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_layout.view.*
import java.util.zip.Inflater
import android.content.Context




class TrackViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.grid_layout, parent,false)){
    private val trackPic : ImageView
    private val tracktitle : TextView




    init {
        trackPic = itemView.findViewById(R.id.trackimage)
        tracktitle = itemView.findViewById(R.id.tracktitle)
    }


    fun bind(tracks: ChartTracks){
        tracktitle?.text = tracks.title
        Picasso.get().load(tracks.album.cover).into(trackPic)
        trackPic.setOnClickListener {
            val intent = Intent(trackPic.context, TrackInfo::class.java)

            intent.putExtra("id", tracks.id.toString())
            startActivity(trackPic.context, intent, null)
        }

    }

}


class TrackListAdapter ( private val list : ArrayList<ChartTracks>) : RecyclerView.Adapter<TrackViewHolder>(){
    private var listEvents : ArrayList<ChartTracks>? = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrackViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track: ChartTracks = listEvents!!.get(position)
        holder.bind(track)
    }

    override fun getItemCount(): Int = list!!.size




}

