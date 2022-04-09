package com.example.topnews.repository

import com.example.topnews.api.RetrofitInstance
import com.example.topnews.db.ArticleDB

class NewsRepository(
    val db: ArticleDB
) {
    suspend fun getTopNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopNews(countryCode, pageNumber)

}