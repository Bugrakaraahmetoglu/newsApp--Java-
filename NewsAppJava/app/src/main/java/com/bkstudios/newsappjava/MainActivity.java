package com.bkstudios.newsappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.bkstudios.newsappjava.adapters.NewsAdapters;
import com.bkstudios.newsappjava.databinding.ActivityMainBinding;
import com.bkstudios.newsappjava.listeners.NewsListener;
import com.bkstudios.newsappjava.model.NewsModel;
import com.bkstudios.newsappjava.viewModel.NewsViewMmodel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsListener {

    private NewsViewMmodel viewMmodel;
    private ActivityMainBinding activityMainBinding;
    private List<NewsModel> newsModels = new ArrayList<>();
    private NewsAdapters newsAdapters;
    private RecyclerView recyclerView;
    private String youtubeLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        recyclerView = findViewById(R.id.recView);
        newsAdapters = new NewsAdapters(newsModels,(NewsListener) this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newsAdapters);
        doInitialization();
    }


    private void doInitialization(){
        activityMainBinding.recView.setHasFixedSize(true);
        viewMmodel = new ViewModelProvider(this).get(NewsViewMmodel.class);
        newsAdapters = new NewsAdapters(newsModels, (NewsListener) this);
        activityMainBinding.recView.setAdapter(newsAdapters);
        getNews();
    }

    private void getNews(){
        activityMainBinding.setIsLoading(true);
        viewMmodel.getNews("us","dbc4fadb07a34fc58bba15d9929b27b7").observe(this,newsResponse ->{
            activityMainBinding.setIsLoading(false);
            if (newsResponse != null){
                if (newsResponse.getArticles() != null){
                    newsModels.addAll(newsResponse.getArticles());
                    newsAdapters.notifyDataSetChanged();
                }
            }
                });
    }

    public void onClicked(NewsModel newsModel){
        youtubeLink = newsModel.getUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink));
        startActivity(intent);
    }
}