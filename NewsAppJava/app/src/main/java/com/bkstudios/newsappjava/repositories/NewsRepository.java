package com.bkstudios.newsappjava.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bkstudios.newsappjava.response.NewsResponse;
import com.bkstudios.newsappjava.service.ApiClient;
import com.bkstudios.newsappjava.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private ApiService apiService;

    public NewsRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<NewsResponse> getNews(String country, String apiKey){
        MutableLiveData<NewsResponse> data = new MutableLiveData<>();
        apiService.getTopHeadlines(country,apiKey).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
