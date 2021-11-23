package com.magnalleexample.geekbrains_movieviewer.ui.movie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.magnalleexample.geekbrains_movieviewer.R
import com.magnalleexample.geekbrains_movieviewer.app
import com.magnalleexample.geekbrains_movieviewer.databinding.MovieFragmentBinding
import com.magnalleexample.geekbrains_movieviewer.domain.repo.Repo
import com.magnalleexample.geekbrains_movieviewer.log

class MovieFragment : Fragment() {
    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: MovieFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.movie_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        val arguments = MovieFragmentArgs.fromBundle(requireArguments())
        binding.movieData = arguments.movieData
        binding.viewModel = viewModel
        val application = requireNotNull(this.activity).application
        viewModel.repo = application.app.repository
        binding.movieTitleTextView.text = arguments.movieData.name
        application.log("Open movie $arguments.movieData")
        return binding.root
    }


}