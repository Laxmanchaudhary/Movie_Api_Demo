package com.example.mvvm_movie_api_demo.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_movie_api_demo.Repository.MoviesRepository

class Factory(private val repository: MoviesRepository):ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T

    }

}