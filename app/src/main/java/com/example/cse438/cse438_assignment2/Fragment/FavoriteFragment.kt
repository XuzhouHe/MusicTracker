package com.example.cse438.cse438_assignment2.Fragment

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.example.cse438.cse438_assignment2.R
import kotlinx.android.synthetic.main.fragment_trending.*

class FavoriteFragment:Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.cse438.cse438_assignment2.R.layout.fragment_favorite, container, false)



    }

    override fun onStart() {
        super.onStart()
        var image = trackimage
        clear_button.setOnClickListener(){
            image.setImageResource(R.drawable.jbc)
        }
    }
}