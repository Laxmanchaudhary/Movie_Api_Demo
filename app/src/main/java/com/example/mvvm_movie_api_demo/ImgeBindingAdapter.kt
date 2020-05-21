package com.example.mvvm_movie_api_demo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadimage(imageView: ImageView,url:String){
    Glide.with(imageView).load(url).into(imageView)

}