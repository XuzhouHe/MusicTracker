package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.ViewModel.PlaylistTrackViewModel
import com.example.cse438.cse438_assignment2.data.PlaylistTrack
import kotlinx.android.synthetic.main.activity_addtracktolist.*

class AddTrackActivity :AppCompatActivity() {

    lateinit var addbutton: Button
    lateinit var addanother: Button

    lateinit var trackViewModel: PlaylistTrackViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtracktolist)

    }

    override fun onStart() {
        super.onStart()

        var title: String = ""
        var artist: String = " "
        var genre: String = " "
        var time: String = " "
        var rate: String = " "
        var playlist: String = " "

        trackViewModel = ViewModelProvider(this).get(PlaylistTrackViewModel::class.java)


        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            title = bundle!!.getString("title", "empty")
            artist = bundle!!.getString("artist", "empty")
            genre = bundle!!.getString("genre", "empty")
            time = bundle!!.getString("time", "empty")
        }

        addtoplaylisti.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            val rate = trackrate.text.toString()
            val playlist = playlistname.text.toString()

            if(TextUtils.isEmpty(rate)){
                val myToast =
                    Toast.makeText(this, "Please do not put an empty rating", Toast.LENGTH_SHORT)
                myToast.show()
            }

            if (rate.toInt() > 100) {
                val myToast =
                    Toast.makeText(this, "Please enter a rating less then 100", Toast.LENGTH_SHORT)
                myToast.show()
            }

            if (TextUtils.isEmpty(playlist)) {
                System.out.println("we in empty")
                val myToast =
                    Toast.makeText(this, "Please do not put an empty name", Toast.LENGTH_SHORT)
                myToast.show()
            }
            if(TextUtils.isEmpty(rate)!=true){
                if(rate.toIntOrNull()!=null){
                    if (rate.toInt() <= 100) {
                        if (TextUtils.isEmpty(playlist) != true) {
                            var mytrack: PlaylistTrack =
                                PlaylistTrack(title, artist, genre, time, rate, playlist)
                            trackViewModel.insert(mytrack)
                            startActivity(intent)
                        }
                    }
                }
            }

            addtoplaylist2.setOnClickListener {
                var intent = Intent(this, AddTrackActivity::class.java)
                intent.putExtra("title", title)
                intent.putExtra("artist", artist)
                intent.putExtra("genre", genre)
                intent.putExtra("time", time)
                startActivity(intent)
            }


        }
    }

}


