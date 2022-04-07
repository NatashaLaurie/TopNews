package com.example.topnews.api

import com.example.topnews.models.NewsResponse
import com.example.topnews.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {
    @GET("v2/home")
    suspend fun getTopNews(
        @Query("api-key")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/{section}")
    suspend fun getCathegoryNews(
        @Path("section") method: String,
        @Query("api-key")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}