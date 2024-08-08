package com.example.newsapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.Article
import com.example.newsapp.data.NewsResponse
import com.example.newsapp.data.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainNewsViewModel : ViewModel() {
    var mainNewsList = MutableLiveData<NewsResponse>()

    fun getAllMainNews(q: String, apikey:String) {
        Network.service.getAllNews(q, apikey).enqueue(object  : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {
                if ( response.isSuccessful && response.body() != null) {
                    mainNewsList.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

                Log.e("ERROR RETOROFIT","ERROR RETROFIT")
            }
        })
    }
}