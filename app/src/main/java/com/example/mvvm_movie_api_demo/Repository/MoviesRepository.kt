package com.example.mvvm_movie_api_demo.Repository

import com.example.mvvm_movie_api_demo.Api.Api_Request
import com.example.mvvm_movie_api_demo.Api.Movie_Api
import com.example.mvvm_movie_api_demo.Movies

class MoviesRepository(var api:Movie_Api): Api_Request() {

    suspend fun getMoviesRepo()=RequestApi { api.getMovies()}

}