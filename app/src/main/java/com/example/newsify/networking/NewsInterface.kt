package com.example.newsify.networking

import com.example.newsify.BASE_URL
import com.example.newsify.domain.model.NewsDataClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface{
    @GET("top-headlines")
    fun getNews(@Query("country")country: String, @Query("page")page: Int, @Query("apiKey")apiKey: String ="02479e165c314b149d9bbc249dc24e6f") : Call<NewsDataClass>
}

object NewsApiObject{
    val newsInstance : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}