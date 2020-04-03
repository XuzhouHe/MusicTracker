package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.ViewModel.PlaylistTrackViewModel
import com.example.cse438.cse438_assignment2.adapter.TrackInfoAdapter
import com.example.cse438.cse438_assignment2.data.PlaylistTrack
import kotlinx.android.synthetic.main.activity_plalistinfo.*

class ShowTracks :AppCompatActivity(){

    var tracklist :ArrayList<PlaylistTrack> = ArrayList()

    var myplaylisttitle : String = " "

    lateinit var myview : TextView

    lateinit var  trackViewModel: PlaylistTrackViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plalistinfo)

        trackViewModel = ViewModelProvider(this).get(PlaylistTrackViewModel::class.java)


        var bundle :Bundle ?=intent.extras
        if(bundle != null){
            myplaylisttitle = bundle!!.getString("name","3135556")
        }

        playlisttitle.text = myplaylisttitle

        val adapter = TrackInfoAdapter(tracklist)
        tracksinplaylist.adapter = adapter
        tracksinplaylist.layoutManager = LinearLayoutManager(this)
        tracksinplaylist.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        )

        trackViewModel.getalltracksbyplaylist(myplaylisttitle)

        trackViewModel.askedlist.observe(this, Observer {
            tracklist.clear()
            tracklist.addAll(it)
            adapter.notifyDataSetChanged()
        })

        trackViewModel.getalltracksbyplaylist(myplaylisttitle)


    }

    override fun onStart() {
        super.onStart()

        myview = playlisttitle


        myview.text = myplaylisttitle

        clear_button.setOnClickListener{
            trackViewModel.clear()
            tracklist.clear()
        }
        back.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}


