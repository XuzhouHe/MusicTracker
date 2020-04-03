package com.example.cse438.cse438_assignment2.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cse438.cse438_assignment2.ViewModel.TrackViewModel
import com.example.cse438.cse438_assignment2.adapter.TrackListAdapter
import com.example.cse438.cse438_assignment2.data.ChartTracks
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(){

    lateinit var viewModel: TrackViewModel

    lateinit var mySearch: SearchView


    var tracklist :ArrayList<ChartTracks> = ArrayList()
    var searchlist :ArrayList<ChartTracks> = ArrayList()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.cse438.cse438_assignment2.R.layout.fragment_home, container, false)


    }


    override fun onStart() {
        super.onStart()


        var trackadapter = TrackListAdapter(tracklist)
        //var searchtrackadapter = TrackListAdapter(searchlist)
        recyclerView.adapter = trackadapter
        //recyclerView.adapter = searchtrackadapter
        recyclerView.layoutManager = GridLayoutManager(this.context,2)

        viewModel = ViewModelProvider(this).get(TrackViewModel::class.java)

        viewModel!!.trackList.observe(this, Observer {
            tracklist.clear()
            tracklist.addAll(it.tracks.data)
            trackadapter.notifyDataSetChanged()
        })

        viewModel.getChartTracks()

        viewModel!!.searchList.observe(this, Observer {
            searchlist.clear()
            searchlist.addAll(it.data)
            tracklist.clear()
            tracklist.addAll(searchlist)
            trackadapter.notifyDataSetChanged()
        })

        search_box.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                val input:String = search_box.text.toString()
                viewModel.searchTracks(input)
                true
            }
            false
        }

    }


}