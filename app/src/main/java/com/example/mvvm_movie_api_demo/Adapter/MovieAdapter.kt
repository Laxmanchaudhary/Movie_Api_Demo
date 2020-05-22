package com.example.mvvm_movie_api_demo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_movie_api_demo.Movies
import com.example.mvvm_movie_api_demo.OnClick.OnClickListener
import com.example.mvvm_movie_api_demo.R
import com.example.mvvm_movie_api_demo.databinding.MovieRowBinding

class MovieAdapter(var list:List<Movies>, var context: Context,private val onClickListener: OnClickListener):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

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

        holder.movieRowBinding.buttonBook.setOnClickListener {
            onClickListener.onClick(holder.movieRowBinding.buttonBook,list[position],"Sorry cant book now !!")

        }
        holder.movieRowBinding.imageView.setOnClickListener {
            onClickListener.onClick(holder.movieRowBinding.imageView,list[position],list[position].title.toString())
        }
    }

}