package com.example.mvvm_movie_api_demo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_movie_api_demo.Movies
import com.example.mvvm_movie_api_demo.R
import com.example.mvvm_movie_api_demo.databinding.MovieRowBinding

class MovieAdapter(var list:List<Movies>, var context: Context):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(var movieRowBinding: MovieRowBinding) :RecyclerView.ViewHolder(movieRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        DataBindingUtil.inflate(LayoutInflater.
        from(context),R.layout.movie_row,parent,false)
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.movieRowBinding.movie=list[position]
    }

}