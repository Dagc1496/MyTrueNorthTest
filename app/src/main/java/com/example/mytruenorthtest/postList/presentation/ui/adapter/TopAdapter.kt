package com.example.mytruenorthtest.postList.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.mytruenorthtest.databinding.PostItemBinding
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.presentation.ui.viewHolder.PostViewHolder
import com.example.mytruenorthtest.postList.presentation.utils.PostComparator
import javax.inject.Inject

class TopAdapter @Inject constructor() : PagingDataAdapter<Post, PostViewHolder>(PostComparator){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),
                              parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}