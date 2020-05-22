package com.example.mvvm_movie_api_demo.Util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showsnack(msg:String){
    Snackbar.make(this,msg,Snackbar.LENGTH_LONG).show()
}