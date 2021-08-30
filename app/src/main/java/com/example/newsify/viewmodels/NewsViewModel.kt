package com.example.newsify.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsify.networking.NewsApiObject
import com.example.newsify.domain.model.Article
import com.example.newsify.domain.model.NewsDataClass
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    val responses: MutableState<List<Article>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch(IO) {
            getResponses()
        }
    }

    private suspend fun getResponses() {
        val news = NewsApiObject.newsInstance.getNews()
        news.enqueue(object : Callback<NewsDataClass?> {
            override fun onResponse(
                call: Call<NewsDataClass?>,
                response: Response<NewsDataClass?>
            ) {
                val news2 = response.body()
                Log.d("HomeScreen", news2.toString())
                if (news2 != null) {

                    responses.value = news2.articles
                }
                Log.d("HomeScreen", responses.value.toString())
            }

            override fun onFailure(call: Call<NewsDataClass?>, t: Throwable) {
                Log.d("HomeScreen", t.toString())
            }
        })
    }
}