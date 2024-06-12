package com.cp.firstapp.DataBase

import com.cp.firstapp.Models.InstagramPost

@androidx.room.Dao
interface InstagramPostDao {

    @androidx.room.Query("SELECT * FROM InstagramPost")
    suspend fun getAllPosts(): List<InstagramPost>

    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<InstagramPost>)

}