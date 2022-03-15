package com.example.mytruenorthtest.common.helper

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore
import com.example.mytruenorthtest.common.exception.SaveImageException
import java.io.OutputStream
import java.lang.Exception

class SaveImageHelper {

    fun saveImage(context: Context, imageBitmap: Bitmap, imageName: String): Boolean{
        var saved: Boolean
        val outPutStream: OutputStream?

        val contentResolver = context.contentResolver
        val contentValues = ContentValues()
        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, imageName)
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, "DCIM/" + "True North")

        try{
            val imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            outPutStream = contentResolver.openOutputStream(imageUri ?: throw SaveImageException())

            saved = imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outPutStream)
            outPutStream?.flush()
        }catch (exception: Exception){
            saved = false
        }

        return saved
    }
}