//package com.example.cse438.cse438_assignment2.adapter
//
//import android.app.Activity
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.TextView
//import android.widget.ImageView
//import com.example.cse438.cse438_assignment2.R
//import com.example.cse438.cse438_assignment2.data.ChartTracks
//import com.example.cse438.cse438_assignment2.data.PlaylistTrack
//import com.example.cse438.cse438_assignment2.data.Tracks
//import com.squareup.picasso.Picasso
//
//class TrackInfoAdapter (private val tracks : ArrayList<PlaylistTrack>) : BaseAdapter(){
//
//
//    private class ViewHolder(trackview: View?){
//          var title : TextView? = null
//          var artist : TextView? = null
//          var genre : TextView? = null
//          var time: TextView? = null
//          var rate: TextView? = null
//
//        init {
//
//            this.title = trackview?.findViewById(R.id.mytitle)
//            this.artist = trackview?.findViewById(R.id.myartist)
//            this.genre = trackview?.findViewById(R.id.mygenre)
//            this.time = trackview?.findViewById(R.id.mytime)
//            this.rate = trackview?.findViewById(R.id.myrate)
//
//        }
//    }
//
//    override fun getView(position: Int , convertView: View?, parent: ViewGroup?): View {
//        val view: View?
//        val viewHolder: ViewHolder
//        if (convertView == null) {
//            val inflater = LayoutInflater.from(parent!!.context)
//            view = inflater.inflate(R.layout.single_track_layout, null)
//            viewHolder = ViewHolder(view)
//            view?.tag = viewHolder
//        } else {
//            view = convertView
//            viewHolder = view.tag as ViewHolder
//        }
//
//        viewHolder.title?.text = tracks.title
//        viewHolder.artist?.text = tracks.artist
//        viewHolder.genre?.text = tracks.title
//        viewHolder.time?.text = tracks.time
//        viewHolder.rate?.text = tracks.rate
//
//
//
//        return view as View
//    }
//    override fun getItem(position: Int): Any {
//        return 0
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getCount(): Int {
//        return 0
//    }
//
//}

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
import com.example.cse438.cse438_assignment2.data.PlaylistTrack


class TrackInfoViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.single_track_layout, parent,false)){
    var title : TextView? = null
    var artist : TextView? = null
    var genre : TextView? = null
    var time: TextView? = null
    var rate: TextView? = null




    init {
        title = itemView?.findViewById(R.id.mytitle)
        artist = itemView?.findViewById(R.id.myartist)
        genre = itemView?.findViewById(R.id.mygenre)
        time = itemView?.findViewById(R.id.mytime)
        rate = itemView?.findViewById(R.id.myrate)
    }


    fun bind(tracks: PlaylistTrack){
        title?.text = tracks.title
        artist?.text = tracks.artist
        genre?.text = tracks.title
        time?.text = tracks.time
        rate?.text = tracks.rate

    }

}


class TrackInfoAdapter ( private val list : ArrayList<PlaylistTrack>) : RecyclerView.Adapter<TrackInfoViewHolder>(){
    private var listEvents : ArrayList<PlaylistTrack>? = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrackInfoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TrackInfoViewHolder, position: Int) {
        val track: PlaylistTrack = listEvents!!.get(position)
        holder.bind(track)
    }

    override fun getItemCount(): Int = list!!.size




}

