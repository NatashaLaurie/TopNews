package com.example.topnews.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.topnews.R
import com.example.topnews.db.ArticleDB
import com.example.topnews.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_top_news.*

class TopNewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_news)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.newsNavHostFragment
        ) as NavHostFragment

        val navController = navHostFragment.navController

        val newsRepository = NewsRepository(ArticleDB(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        bottomNavigationView.setupWithNavController(navController)
    }
}