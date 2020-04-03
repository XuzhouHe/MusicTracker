//package com.example.cse438.cse438_assignment2
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.cse438.cse438_assignment2.Fragment.HomeFragment
//import com.example.cse438.cse438_assignment2.Fragment.PlaylistFragment
//import com.example.cse438.cse438_assignment2.adapter.ViewPageAdapter
//import kotlinx.android.synthetic.main.activity_main.*
//
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//
//        val adapter =
//            ViewPageAdapter(supportFragmentManager)
//        adapter.addFragment(HomeFragment(), "Home")
//        adapter.addFragment(PlaylistFragment(), "Playlist")
//        viewPager?.adapter = adapter
//        tabs.setupWithViewPager(viewPager)
//
//    }
//}

package com.example.cse438.cse438_assignment2

//import sun.jvm.hotspot.utilities.IntArray
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cse438.cse438_assignment2.Fragment.FavoriteFragment
import com.example.cse438.cse438_assignment2.Fragment.HomeFragment
import com.example.cse438.cse438_assignment2.Fragment.PlaylistFragment
import com.example.cse438.cse438_assignment2.Fragment.TrendingFragment
import com.example.cse438.cse438_assignment2.adapter.ViewPageAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var findbutton: SearchView
    lateinit var findbox: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(PlaylistFragment(), "Playlist")
        adapter.addFragment(TrendingFragment(),"Trending")
        adapter.addFragment(FavoriteFragment(),"Favorite")
        viewPager?.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

}
