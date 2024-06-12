package com.cp.firstapp.DataBase

import android.content.Context
import androidx.room.Database
import com.cp.firstapp.Models.InstagramPost

@Database(entities = [InstagramPost::class], version = 1)
abstract class InstagramPostDatabase : androidx.room.RoomDatabase() {

    abstract fun instagramPostDao(): InstagramPostDao

    companion object {

        @Volatile
        private var INSTANCE: InstagramPostDatabase? = null

        fun getInstance(context: Context): InstagramPostDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    InstagramPostDatabase::class.java,
                    "instagram_post_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}