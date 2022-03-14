package com.example.mytruenorthtest.postList.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.mytruenorthtest.postList.domain.model.Post

object PostComparator : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Post, newItem: Post) =
        oldItem.title == newItem.title &&
        oldItem.author == newItem.author
}