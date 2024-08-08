package com.example.newsapp.data.network

import com.example.newsapp.data.Article
import com.example.newsapp.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    //https://newsapi.org/v2/everything?q=turkiye&apiKey=a106dbc1b6634bf68b0e1dd0a263ee40

    @GET("v2/everything")
    fun getAllNews(@Query("q") q: String, @Query("apikey") apikey: String): Call<NewsResponse>
}