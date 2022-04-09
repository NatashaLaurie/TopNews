package com.example.topnews.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topnews.models.NewsResponse
import com.example.topnews.repository.NewsRepository
import com.example.topnews.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

    val topNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var topNewsPge = 1

    init {
        getTopNews("us")
    }

    fun getTopNews(countryCode: String) = viewModelScope.launch {
        topNews.postValue(Resource.Loading())
        val response = newsRepository.getTopNews(countryCode, topNewsPge)
        topNews.postValue(handleTopNewsResponse(response))
    }

    private fun handleTopNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}