package com.cp.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cp.firstapp.UI.InstagramPostFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of the InstagramPostFragment
        val fragment = InstagramPostFragment()

        // Get the FragmentManager and begin a transaction
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        // Add the fragment to the container view
        transaction.add(R.id.fragment_container, fragment)

        // Commit the transaction
        transaction.commit()
    }
}