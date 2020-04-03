package com.example.cse438.cse438_assignment2.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse438.cse438_assignment2.PlaylistActivity
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.ViewModel.PlaylistViewModel
import com.example.cse438.cse438_assignment2.adapter.PlayListAdapter
import com.example.cse438.cse438_assignment2.data.Playlist
import kotlinx.android.synthetic.main.fragment_playlist.*

class PlaylistFragment :Fragment() {
    private lateinit var viewModel: PlaylistViewModel
    private var playlist: ArrayList<Playlist> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false)

    }

    override fun onStart() {
        super.onStart()
        add_button.setOnClickListener() {
            //found the button
            var intent = Intent(this.context, PlaylistActivity::class.java)
            startActivity(intent)
        }
        var adapter = PlayListAdapter(playlist)
        joke_recycler_view.adapter = adapter
        joke_recycler_view.layoutManager = LinearLayoutManager(this.context)
        joke_recycler_view.addItemDecoration(
            DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL)
        )
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

        viewModel!!.wholePlaylist.observe(this, Observer {playlist_table ->
            playlist.clear()
            playlist.addAll(playlist_table)
            adapter.notifyDataSetChanged()

        })

        clear_button.setOnClickListener {
            viewModel.clear()
            playlist.clear()
        }
    }
}

