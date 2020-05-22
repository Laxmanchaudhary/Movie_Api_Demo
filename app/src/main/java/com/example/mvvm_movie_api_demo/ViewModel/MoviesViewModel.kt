package com.example.mvvm_movie_api_demo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_movie_api_demo.Movies
import com.example.mvvm_movie_api_demo.Repository.MoviesRepository
import kotlinx.coroutines.*

class MoviesViewModel(var repo: MoviesRepository): ViewModel() {

    var job: CompletableJob? = null
    var movie: LiveData<List<Movies>>

    init {
        var mymovie=getmoviesfromvi()
        movie=mymovie

    }


    fun getmoviesfromvi(): MutableLiveData<List<Movies>> {
        job=Job()

        return object : MutableLiveData<List<Movies>>() {
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(Dispatchers.IO).launch {
                        var moviedata=repo.getMoviesRepo()
                        withContext(Dispatchers.Main){
                            value=moviedata
                            job?.complete()
                        }
                    }

                }


            }

        }

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
