package com.cp.firstapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "InstagramPost")
data class InstagramPost(
    @PrimaryKey
    val id: Int,
    val user: String,
    val caption: String?="",
    val image: String,
    val likes: Int,
    val comments: String?=""
)