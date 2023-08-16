package com.bkstudios.newsappjava.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bkstudios.newsappjava.repositories.NewsRepository;
import com.bkstudios.newsappjava.response.NewsResponse;

public class NewsViewMmodel extends ViewModel {

    private NewsRepository newsRepository;

    public NewsViewMmodel(){
        newsRepository = new NewsRepository();
    }

    public LiveData<NewsResponse> getNews(String country,String apiKey){
        return newsRepository.getNews(country, apiKey);
    }
}
