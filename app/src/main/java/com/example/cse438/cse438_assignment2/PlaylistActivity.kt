package com.example.cse438.cse438_assignment2

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cse438.cse438_assignment2.ViewModel.PlaylistViewModel
import com.example.cse438.cse438_assignment2.data.Playlist
import kotlinx.android.synthetic.main.activity_playlist.*
import kotlinx.android.synthetic.main.playlist_layout.*
import org.w3c.dom.Text


class PlaylistActivity: AppCompatActivity(){

    public lateinit var playlistViewModel : PlaylistViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)
        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
    }




    override fun onStart() {
        super.onStart()
        System.out.println("here is onstart in PA")

        addtoplaylistfrompacti.setOnClickListener(){
            var pname = playlist_name.text.toString()
            var pdescrip = playlist_description.text.toString()
            var pgenre = playlist_genre.text.toString()
            var prating = playlist_rating.text.toString().toInt()


            if(TextUtils.isEmpty(pname)){
                val myToast =
                    Toast.makeText(this, "Please do not put an empty name", Toast.LENGTH_SHORT)
                myToast.show()
            }
            if(TextUtils.isEmpty(pdescrip)){
                val myToast =
                    Toast.makeText(this, "Please do not put an empty description", Toast.LENGTH_SHORT)
                myToast.show()
            }
            if(TextUtils.isEmpty(pgenre)){
                val myToast =
                    Toast.makeText(this, "Please do not put an empty genre", Toast.LENGTH_SHORT)
                myToast.show()
            }
            if(TextUtils.isEmpty(prating.toString())){
                val myToast =
                    Toast.makeText(this, "Please do not put an empty rating", Toast.LENGTH_SHORT)
                myToast.show()
            }



            var playlistmy = Playlist(pname,pdescrip,pgenre,prating)

            if(TextUtils.isEmpty(pname)!=true){
                if(TextUtils.isEmpty(pdescrip)!=true){
                    if(TextUtils.isEmpty(pgenre)!=true){
                        if(TextUtils.isEmpty((prating.toString()))!=true){
                            playlistViewModel!!.insert(playlistmy)

                            var intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
//            playlistViewModel!!.insert(playlistmy)
//
//            var intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)


        }
    }

}
