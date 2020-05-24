package com.example.mvvm_movie_api_demo.Internet

import android.content.Context
import android.net.ConnectivityManager
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import com.example.mvvm_movie_api_demo.Util.Exception
import okhttp3.Interceptor
import okhttp3.Response

class NetworkIntercepter(context: Context):Interceptor {
    var applicationContext = context.applicationContext


    fun isConnected(): Boolean {
        var manager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var info = manager.activeNetworkInfo
        return info.isConnected && info != null

    }

    override fun intercept(chain: Interceptor.Chain): Response {
            if (!isConnected()) {
                throw Exception("No Internet")
            } else {
                return chain.proceed(chain.request())
            }

        }

    }
