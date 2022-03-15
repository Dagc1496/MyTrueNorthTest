package com.example.mytruenorthtest.postList.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.mytruenorthtest.databinding.PostItemBinding
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.presentation.helper.ISwipeToDelete
import com.example.mytruenorthtest.postList.presentation.ui.viewHolder.PostViewHolder
import com.example.mytruenorthtest.postList.presentation.utils.PostComparator

class TopAdapter(private val itemListener: (Int, Post) -> Unit,
                 private val imageListener: (String) -> Unit,
                 private val deleteListener: (Int, String) -> Unit
) : PagingDataAdapter<Post, PostViewHolder>(PostComparator),  ISwipeToDelete{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),
                              parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { post ->
            holder.onBind(post, itemListener, imageListener)
        }
    }

    override fun deleteItem(position: Int) {
        deleteListener(position, getItem(position)?.title ?: "")
    }
}