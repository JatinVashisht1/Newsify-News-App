package com.example.newsify.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsify.networking.NewsApiObject
import com.example.newsify.domain.model.Article
import com.example.newsify.domain.model.NewsDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
     val _response = MutableLiveData<List<Article>>()
    val response : LiveData<List<Article>>
    get() = _response

    init {
        getResponses()

//        Log.d("HomeScreen", _response.value.toString())
    }

    private fun getResponses() {
        val news = NewsApiObject.newsInstance.getNews("in", 1)
        news.enqueue(object : Callback<NewsDataClass?> {
            override fun onResponse(
                call: Call<NewsDataClass?>,
                response: Response<NewsDataClass?>
            ) {
                val news2 = response.body()
                if (news2 != null) {
//
//                        _response.postValue(news2.articles)

                    _response.value = news2.articles
                }
            }

            override fun onFailure(call: Call<NewsDataClass?>, t: Throwable) {
                Log.d("HomeScreen", t.toString())
            }
        })
    }
}