package com.cp.firstapp.UI

import com.cp.firstapp.ViewModels.InstagramPostViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cp.firstapp.DataBase.InstagramPostDatabase
import com.cp.firstapp.DataBase.InstagramPostRepository
import com.cp.firstapp.ViewModels.InstagramPostViewModel
import com.cp.firstapp.R

class InstagramPostFragment : Fragment() {


    private val viewModel: InstagramPostViewModel by viewModels{
        InstagramPostViewModelFactory(
        InstagramPostRepository(InstagramPostDatabase.getInstance(requireContext()).instagramPostDao())
    )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instagram_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
       val adapter= InstagramPostAdapter()
        recyclerView.adapter =adapter
        viewModel.loadPosts()

        viewModel.posts.observe(viewLifecycleOwner) { posts ->
            adapter.setData(posts)
            // Update your UI with the list of Instagram posts.
        }
    }
}