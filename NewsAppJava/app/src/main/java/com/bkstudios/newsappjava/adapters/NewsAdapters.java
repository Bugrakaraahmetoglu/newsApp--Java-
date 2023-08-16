package com.bkstudios.newsappjava.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bkstudios.newsappjava.R;
import com.bkstudios.newsappjava.databinding.ItemsBinding;
import com.bkstudios.newsappjava.listeners.NewsListener;
import com.bkstudios.newsappjava.model.NewsModel;

import java.util.List;

public class NewsAdapters extends RecyclerView.Adapter<NewsAdapters.newsViewHolder>{

    private List<NewsModel> newsModels;
    private LayoutInflater layoutInflater;
    private static NewsListener newsListener;

    public NewsAdapters(List<NewsModel> newsModels,NewsListener newsListener) {
        this.newsModels = newsModels;
        this.newsListener = newsListener;
    }

    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    if(layoutInflater == null){
        layoutInflater = LayoutInflater.from(parent.getContext());
    }
    ItemsBinding itemsBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.items,parent,false
    );

    return new newsViewHolder(itemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {
        holder.bindNews(newsModels.get(position));
    }



    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    static class newsViewHolder extends RecyclerView.ViewHolder{

        private ItemsBinding itemsBinding;

        public newsViewHolder(ItemsBinding itemsBinding){
            super(itemsBinding.getRoot());
            this.itemsBinding = itemsBinding;
        }

        public void bindNews(NewsModel newsModel){
            itemsBinding.setNews(newsModel);
            itemsBinding.executePendingBindings();
            itemsBinding.getRoot().setOnClickListener(v-> newsListener.onClicked(newsModel));
        }
    }
}
