package com.cp.firstapp.DataBase

import android.util.Log
import com.cp.firstapp.Models.InstagramPost


class InstagramPostRepository(private val instagramPostDao: InstagramPostDao) {

    suspend fun getPosts(): List<InstagramPost> {
        // Check if there are any posts in the database.
        val cachedPosts = instagramPostDao.getAllPosts()
        if (cachedPosts.isNotEmpty()) {
            Log.d("InstagramPostRepository", "Returning cached posts.")
            return cachedPosts
        }

        // Fetch posts from the network.
        val networkPosts = fetchPostsFromNetwork()

        // Save the posts to the database.
        instagramPostDao.insertAll(networkPosts)
        Log.d("InstagramPostRepository", "Returning network posts.")

        return networkPosts
    }

    private suspend fun fetchPostsFromNetwork(): List<InstagramPost> {
        // Code to fetch posts from the network goes here.
        // For simplicity, we'll just create some dummy data.
        return listOf(
            InstagramPost(image = "https://example.com/post1.jpg", user = "abcd", caption = "This is post 1.", likes = 12,id=1),
            InstagramPost(image = "https://example.com/post2.jpg", user =  "few", caption = "This is post 2.", likes = 100,id=2),
            InstagramPost(image = "https://example.com/post3.jpg", user =  "fewf", caption = "This is post 3.", likes = 21,id=3)
        )
    }
}