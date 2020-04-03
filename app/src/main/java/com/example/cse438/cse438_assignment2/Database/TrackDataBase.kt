package com.example.cse438.cse438_assignment2.Database


import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cse438.cse438_assignment2.data.Playlist
import com.example.cse438.cse438_assignment2.data.PlaylistTrack

@Database(entities = arrayOf(PlaylistTrack::class), version = 2)
public abstract class TrackDataBase:RoomDatabase(){
    abstract fun trackDao():TrackDao

    //singleton pattern
    companion object{
        @Volatile
        public var INSTANCE: TrackDataBase? = null

        fun getDatabase(context:Context): TrackDataBase{
            val temp = INSTANCE
            if(temp!=null){
                return temp
            }
            synchronized(this){
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    TrackDataBase::class.java,
                    "track_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}
