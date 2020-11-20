package com.techand.thenewsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techand.thenewsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
): ViewModel(){

}