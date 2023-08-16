package com.bkstudios.newsappjava.service;

import com.bkstudios.newsappjava.response.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);
}
