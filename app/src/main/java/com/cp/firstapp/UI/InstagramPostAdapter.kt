package com.cp.firstapp.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cp.firstapp.Models.InstagramPost
import com.cp.firstapp.R

class InstagramPostAdapter :
    RecyclerView.Adapter<InstagramPostAdapter.ViewHolder>() {
    private var instagramPosts: List<InstagramPost> = emptyList()
        fun setData(instagramPosts: List<InstagramPost>)
      {
           this.instagramPosts = instagramPosts
           notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val instagramPost = instagramPosts[position]
        holder.bind(instagramPost)
    }

    override fun getItemCount(): Int = instagramPosts.size

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(instagramPost: InstagramPost) {
            val imageView=itemView.findViewById<ImageView>(R.id.image)
            val captionView=itemView.findViewById<TextView>(R.id.caption)
            Glide.with(itemView.context)
                .load(instagramPost.image)
                .into(imageView)
            captionView.text=instagramPost.caption
        }
    }
}