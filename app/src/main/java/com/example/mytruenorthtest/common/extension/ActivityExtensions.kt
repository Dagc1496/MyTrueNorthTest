package com.example.mytruenorthtest.common.extension

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

fun AppCompatActivity.showSnackBar(view: View, message: String){
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}