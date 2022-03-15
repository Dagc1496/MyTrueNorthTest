package com.example.mytruenorthtest.postList.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytruenorthtest.common.extension.setImageFromUrl
import com.example.mytruenorthtest.databinding.ActivityImagePreviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImagePreviewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityImagePreviewBinding
    private var thumbnailUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getThumbnailExtra()
        setThumbnailImage()
    }

    private fun setThumbnailImage() {
        binding.imageViewImagePreview.setImageFromUrl(thumbnailUrl, this)
    }

    private fun getThumbnailExtra() {
        thumbnailUrl = intent.getStringExtra("thumbnail").toString()
    }
}