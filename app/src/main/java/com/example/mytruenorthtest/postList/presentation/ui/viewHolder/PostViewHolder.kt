package com.example.mytruenorthtest.postList.presentation.ui.viewHolder

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytruenorthtest.databinding.PostItemBinding
import com.example.mytruenorthtest.postList.domain.model.Post

class PostViewHolder(binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root){

    val textViewPostTitle : TextView = binding.textViewPostTitle
    val textViewPostAuthor : TextView = binding.textViewPostAuthor
    val textViewPostComments : TextView = binding.textViewPostCommentsAmount
    val textViewPostCreated : TextView = binding.textViewPostCreated
    val textViewPostNew : TextView = binding.textViewPostNew

    fun onBind(post: Post){
        textViewPostTitle.text = post.title
        textViewPostAuthor.text = post.author
        textViewPostComments.text = post.numberComments.toString()
        textViewPostCreated.text = post.created.toString()
        textViewPostNew.text = post.new.toString()
    }
}