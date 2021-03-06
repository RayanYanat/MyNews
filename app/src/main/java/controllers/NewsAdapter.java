package controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.R;

import java.util.List;

import models.TopStoriesArticles;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ImageViewHolder> {

    private List<TopStoriesArticles> mData;

    public NewsAdapter(List<TopStoriesArticles> data) {

        mData = data;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        TopStoriesArticles topSortiesItem =mData.get(position);
        holder.newsTittle.setText(topSortiesItem.getTitle());
        holder.newsDate.setText(topSortiesItem.getPublishedDate());
        holder.newsArticle.setText(topSortiesItem.getSubsection());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setResults(List<TopStoriesArticles> results) {
        this.mData=results;
        notifyDataSetChanged();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsTittle;
        TextView newsDate;
        TextView newsArticle;

        ImageViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_item_image);
            newsTittle = itemView.findViewById(R.id.news_item_title);
            newsDate = itemView.findViewById(R.id.news_item_date);
            newsArticle = itemView.findViewById(R.id.news_item_article);

        }

    }
}
