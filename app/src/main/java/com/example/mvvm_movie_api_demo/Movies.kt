package com.example.mvvm_movie_api_demo

data class Movies(
    val id: Int,
    val image: String,
    val is_new: Int,
    val language: String,
    val like_percent: String,
    val rating: String,
    val title: String,
    val type: String,
    val vote_count: Int
)