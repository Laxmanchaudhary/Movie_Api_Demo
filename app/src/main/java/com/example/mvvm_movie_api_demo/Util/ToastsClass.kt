package com.example.mvvm_movie_api_demo.Util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.showToast(msg:String){
    Toast.makeText(this, msg,Toast.LENGTH_LONG).show()
}

