package com.example.topnews.ui

import androidx.lifecycle.ViewModel
import com.example.topnews.repository.NewsRepository

class NewsViewModel (
    val newsRepository: NewsRepository
        ): ViewModel() {
}