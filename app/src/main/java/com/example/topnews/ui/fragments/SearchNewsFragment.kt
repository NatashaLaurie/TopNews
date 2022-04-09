package com.example.topnews.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.topnews.R
import com.example.topnews.ui.NewsViewModel
import com.example.topnews.ui.TopNewsActivity

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as TopNewsActivity).viewModel
    }
}