package com.example.mvvm_movie_api_demo.View

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_movie_api_demo.Adapter.MovieAdapter
import com.example.mvvm_movie_api_demo.Api.Movie_Api
import com.example.mvvm_movie_api_demo.Movies
import com.example.mvvm_movie_api_demo.OnClick.OnClickListener
import com.example.mvvm_movie_api_demo.ViewModel.MoviesViewModel
import com.example.mvvm_movie_api_demo.R
import com.example.mvvm_movie_api_demo.Repository.MoviesRepository
import com.example.mvvm_movie_api_demo.Util.showToast
import com.example.mvvm_movie_api_demo.Util.showsnack
import com.example.mvvm_movie_api_demo.ViewModel.Factory
import kotlinx.android.synthetic.main.movie_row.*
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(),OnClickListener {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var factory: Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var api=Movie_Api()
        var repository=MoviesRepository(api)
        factory= Factory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(MoviesViewModel::class.java)
        viewModel.movie.observe(requireActivity(), Observer {  movie->

                movies_recyclerview.also {
                    it.setHasFixedSize(true)
                    it.layoutManager=LinearLayoutManager(requireContext())
                    it.adapter=MovieAdapter(movie,requireContext(),this)
                }

        })

    }

    override fun onClick(view: View, movie: Movies, msg: String) {
        when(view.id){
            //R.id.button_book->Toast.makeText(requireActivity(),msg,Toast.LENGTH_LONG).show()
            R.id.button_book->mainlayout.showsnack(msg)
            R.id.imageView->mainlayout.showsnack(msg)
        }

    }

}
