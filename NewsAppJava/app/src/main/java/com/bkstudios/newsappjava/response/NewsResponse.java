package com.bkstudios.newsappjava.response;

import com.bkstudios.newsappjava.model.NewsModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<NewsModel> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsModel> getArticles() {
        return articles;
    }
}
