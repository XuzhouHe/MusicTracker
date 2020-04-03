package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.ViewModel.PlaylistTrackViewModel
import com.example.cse438.cse438_assignment2.ViewModel.TrackViewModel
import com.example.cse438.cse438_assignment2.adapter.TrackInfoAdapter
import com.example.cse438.cse438_assignment2.adapter.TrackListAdapter
import com.example.cse438.cse438_assignment2.data.ChartAlbum
import com.example.cse438.cse438_assignment2.data.ChartArtist
import com.example.cse438.cse438_assignment2.data.ChartTracks
import com.example.cse438.cse438_assignment2.data.Tracks
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_trackinfo.*

class TrackInfo : AppCompatActivity() {

    var myid: String = ""

    lateinit var viewModel: TrackViewModel


    lateinit var backbutton : Button

    lateinit var addbutton : Button

    private var mytrackview: ListView? = null

    var title : TextView? = null
    var image : ImageView? = null
    var artist : TextView? = null
    var title2 : TextView? = null
    var position: TextView? = null
    var length: TextView? = null
    var release: TextView? = null
    var rank: TextView? = null
    var gain: TextView? = null




    var myalbum : ChartAlbum = ChartAlbum(
        27,
        "Daft Punk",
        "https://www.deezer.com/artist/27",
        "https://www.deezer.com/artist/27?utm_source=deezer&utm_content=artist-27&utm_term=0_1582844647&utm_medium=web",
        "https://api.deezer.com/artist/27/image",
        "https://cdns-images.dzcdn.net/images/artist/f2bc007e9133c946ac3c3907ddc5d2ea/56x56-000000-80-0-0.jpg",
        "https://cdns-images.dzcdn.net/images/artist/f2bc007e9133c946ac3c3907ddc5d2ea/250x250-000000-80-0-0.jpg",
        "https://cdns-images.dzcdn.net/images/artist/f2bc007e9133c946ac3c3907ddc5d2ea/500x500-000000-80-0-0.jpg",
        "https://cdns-images.dzcdn.net/images/artist/f2bc007e9133c946ac3c3907ddc5d2ea/1000x1000-000000-80-0-0.jpg"

    )

    var myartists : ChartArtist = ChartArtist(
        1,"","","","","","","",true,"",""
    )

    var mytrack : Tracks = Tracks(
        "ricky",
        "Harder, Better, Faster, Stronger",
        "224",
        4,
        "751105",
        "2001-03-07",
        -12.4,
        myartists,
        myalbum,
        "track"

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trackinfo)

        this.title = findViewById(R.id.mytitle)
        this.image = findViewById(R.id.trackimage)
        this.artist = findViewById(R.id.myartist)
        this.title2 = findViewById(R.id.mytitle2)
        this.position = findViewById(R.id.myposition)
        this.length = findViewById(R.id.length1)
        this.release = findViewById(R.id.release1)
        this.rank = findViewById(R.id.rank1)
        this.gain = findViewById(R.id.gain1)
        viewModel = ViewModelProvider(this).get(TrackViewModel::class.java)
        backbutton = back
        addbutton = addtoplaylist







        var bundle :Bundle ?=intent.extras
        if(bundle != null){
            myid = bundle!!.getString("id","3135556")
        }

        System.out.println("---------------------------"+myid)
        viewModel.getTracks(myid)

        viewModel!!.track.observe(this, Observer {
            mytrack = it
            title?.text = mytrack.title
            Picasso.get().load(mytrack.album.cover).into(image)
            artist?.text = mytrack.artist.name
            title2?.text = mytrack.title
            position?.text = mytrack.track_position.toString()
            length?.text = mytrack.duration
            release?.text = mytrack.release_date
            rank?.text = mytrack.rank
            gain?.text = mytrack.gain.toString()
        })







    }

    override fun onStart() {
        super.onStart()

        backbutton.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        addbutton.setOnClickListener {
            var intent = Intent(this,AddTrackActivity::class.java)
            intent.putExtra("title", mytrack.title)
            intent.putExtra("artist", mytrack.artist.name)
            intent.putExtra("genre", mytrack.title)
            intent.putExtra("time", mytrack.duration)



            startActivity(intent)
        }









    }
}