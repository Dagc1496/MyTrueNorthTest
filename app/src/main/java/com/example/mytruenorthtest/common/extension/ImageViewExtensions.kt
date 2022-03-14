package com.example.mytruenorthtest.common.extension

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


fun ImageView.setImageFromUrl(url: String, context: Context){
    Glide.with(context).load(url)
        .apply(
            RequestOptions()
                .fitCenter()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .override(Target.SIZE_ORIGINAL)
        )
        .into(this)
}