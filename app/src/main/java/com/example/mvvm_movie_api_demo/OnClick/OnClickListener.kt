package com.example.mvvm_movie_api_demo.OnClick

import android.view.View
import com.example.mvvm_movie_api_demo.Movies

interface OnClickListener {
    fun onClick(view: View, movie: Movies, msg:String)
}