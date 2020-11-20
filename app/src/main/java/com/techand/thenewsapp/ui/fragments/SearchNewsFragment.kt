package com.techand.thenewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.techand.thenewsapp.R
import com.techand.thenewsapp.ui.NewsActivity
import com.techand.thenewsapp.ui.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {


    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}