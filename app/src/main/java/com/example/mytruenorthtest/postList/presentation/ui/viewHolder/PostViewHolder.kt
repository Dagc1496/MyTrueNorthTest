package com.example.mytruenorthtest.postList.presentation.ui.viewHolder

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mytruenorthtest.R
import com.example.mytruenorthtest.common.extension.setImageFromUrl
import com.example.mytruenorthtest.databinding.PostItemBinding
import com.example.mytruenorthtest.postList.domain.model.Post

class PostViewHolder(binding: PostItemBinding, val context: Context) : RecyclerView.ViewHolder(binding.root){

    val textViewPostTitle : TextView = binding.textViewPostTitle
    val textViewPostAuthor : TextView = binding.textViewPostAuthor
    val textViewPostComments : TextView = binding.textViewPostCommentsAmount
    val textViewPostCreated : TextView = binding.textViewPostCreated
    val textViewPostNew : TextView = binding.textViewPostNew
    val imageViewPostThumbnail : ImageView = binding.imageViewPostThumbnail

    fun onBind(post: Post,
               itemClick: (Post) -> Unit,
               imageClick: (String) -> Unit){
        textViewPostTitle.text = post.title
        textViewPostAuthor.text = post.author
        textViewPostComments.text = post.numberComments.toString()
        textViewPostCreated.text = post.created.toString()

        setImageThumbnail(post)
        setPostState(post)

        itemView.setOnClickListener {
            post.new = false
            itemClick(post)
        }
        imageViewPostThumbnail.setOnClickListener { imageClick(post.thumbnail) }
    }

    private fun setImageThumbnail(post : Post){
        imageViewPostThumbnail.setImageFromUrl(post.thumbnail, context)
    }

    private fun setPostState(post : Post){
        if (post.new){
            textViewPostNew.text = context.getString(R.string.new_post)
            textViewPostNew.setTextColor(ContextCompat.getColor(context, R.color.green))
        }else{
            textViewPostNew.text = context.getString(R.string.old_post)
            textViewPostNew.setTextColor(ContextCompat.getColor(context, R.color.gray))
        }
    }
}