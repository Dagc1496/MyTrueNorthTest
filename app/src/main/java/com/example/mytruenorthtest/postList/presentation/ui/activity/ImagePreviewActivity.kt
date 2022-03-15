package com.example.mytruenorthtest.postList.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.isVisible
import com.example.mytruenorthtest.R
import com.example.mytruenorthtest.common.extension.setImageFromUrl
import com.example.mytruenorthtest.common.extension.showSnackBar
import com.example.mytruenorthtest.common.helper.SaveImageHelper
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

        binding.buttonSaveImage.setOnClickListener{
            saveImage()
        }

        getThumbnailExtra()
        setThumbnailImage()
    }

    private fun setThumbnailImage() {
        binding.imageViewImagePreview.setImageFromUrl(thumbnailUrl, this)
    }

    private fun getThumbnailExtra() {
        thumbnailUrl = intent.getStringExtra("thumbnail").toString()
    }

    private fun saveImage() {
        setLoadState(true)
        val saveImageHelper = SaveImageHelper()
        val imageSaved = saveImageHelper.saveImage(this, binding.imageViewImagePreview.drawable.toBitmap(), thumbnailUrl)
        setLoadState(false)

        showMessage(imageSaved)
    }

    private fun showMessage(success: Boolean) {
        val message:String
        if(success){
            message = getString(R.string.image_saved)
        }else{
            message = getString(R.string.error_saving_image)
        }
        showSnackBar(binding.root, message)
    }

    private fun setLoadState(isLoading: Boolean) {
        binding.progressBarLoader.isVisible = isLoading
    }
}