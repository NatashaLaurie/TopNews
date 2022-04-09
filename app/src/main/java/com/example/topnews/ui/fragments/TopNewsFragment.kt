package com.example.topnews.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topnews.R
import com.example.topnews.adapters.NewsAdapter
import com.example.topnews.ui.NewsViewModel
import com.example.topnews.ui.TopNewsActivity
import com.example.topnews.util.Resource
import kotlinx.android.synthetic.main.fragment_top_news.*

class TopNewsFragment : Fragment(R.layout.fragment_top_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    private val TAG = "TopNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as TopNewsActivity).viewModel
        setupRecyclerView()

        viewModel.topNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }

                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occurred: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()

                }
            }

        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}