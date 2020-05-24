package com.example.mvvm_movie_api_demo.Api

import retrofit2.Response
import java.lang.Exception

abstract class Api_Request() {


   suspend fun<T:Any> RequestApi(call:suspend()->Response<T>):T{
       var res=call.invoke()


           if (res.isSuccessful){
               return res.body()!!
           }else{
               throw Exception("${res.code()}")
           }





    }



}