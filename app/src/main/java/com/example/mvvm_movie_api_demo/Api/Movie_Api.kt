package com.example.mvvm_movie_api_demo.Api

import com.example.mvvm_movie_api_demo.Movies
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Movie_Api {

    @GET("movies")
   suspend fun getMovies():Response<List<Movies>>



    companion object{
        var base_url="https://api.simplifiedcoding.in/course-apis/recyclerview/"
        operator fun invoke():Movie_Api{
          return  Retrofit.Builder().baseUrl(base_url).
          addConverterFactory(GsonConverterFactory.create()).
          build().create(Movie_Api::class.java)

        }
    }
}