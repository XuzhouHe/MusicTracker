package com.example.cse438.cse438_assignment2.Database

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cse438.cse438_assignment2.data.Playlist

@Database(entities = arrayOf(Playlist::class), version = 2)
public abstract class PlaylistDataBase:RoomDatabase(){
    abstract fun playlistDao():PlaylistDao

    //singleton pattern
    companion object{
        @Volatile
        public var INSTANCE: PlaylistDataBase? = null

        fun getDatabase(context:Context): PlaylistDataBase{
            val temp = INSTANCE
            if(temp!=null){
                return temp
            }
            synchronized(this){
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    PlaylistDataBase::class.java,
                    "playlist_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}
