package com.example.mytruenorthtest.postList.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytruenorthtest.databinding.PostItemBinding
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.presentation.ui.viewHolder.PostViewHolder

class TopAdapter(
    private val postList : List<Post>
) : RecyclerView.Adapter<PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),
                              parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]

        holder.onBind(post)
    }

    override fun getItemCount(): Int = postList.size
}