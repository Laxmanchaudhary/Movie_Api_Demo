package com.example.mvvm_movie_api_demo.Api

import com.example.mvvm_movie_api_demo.Internet.NetworkIntercepter
import com.example.mvvm_movie_api_demo.Movies
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Movie_Api {

    @GET("movies")
   suspend fun getMovies():Response<List<Movies>>



    companion object{
        var base_url="https://api.simplifiedcoding.in/course-apis/recyclerview/"

        operator fun invoke( interceptor:NetworkIntercepter):Movie_Api{

            var buildervlient=OkHttpClient.Builder().addInterceptor(interceptor).build()

          return  Retrofit.Builder().baseUrl(base_url).client(buildervlient).
          addConverterFactory(GsonConverterFactory.create()).
          build().create(Movie_Api::class.java)

        }
    }
}