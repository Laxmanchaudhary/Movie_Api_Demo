package com.example.mvvm_movie_api_demo.View

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_movie_api_demo.Adapter.MovieAdapter
import com.example.mvvm_movie_api_demo.Api.Movie_Api
import com.example.mvvm_movie_api_demo.R
import com.example.mvvm_movie_api_demo.Repository.MoviesRepository
import com.example.mvvm_movie_api_demo.Util.showToast
import com.example.mvvm_movie_api_demo.ViewModel.Factory
import com.example.mvvm_movie_api_demo.ViewModel.MoviesViewModel
import kotlinx.android.synthetic.main.movies_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var factory: Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       var controller= findNavController(R.id.fragment)
        setupActionBarWithNavController(controller,null)
    }
}
