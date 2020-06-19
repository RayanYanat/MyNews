package views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.R;

import java.util.ArrayList;
import java.util.List;

import controllers.NewsAdapter;
import models.TopStoriesArticles;

import utils.TopStoriesCall;

public class TabOne extends Fragment implements TopStoriesCall.Callbacks {

    private RecyclerView recyclerView ;
    private List<TopStoriesArticles> results ;
    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView=view.findViewById(R.id.MyRecyclerView);
        this.setUpRecyclerView();
        this.executeHttpRequestWithRetrofit();
        return view;
    }

    private void executeHttpRequestWithRetrofit(){
        TopStoriesCall.fetchTopStoriesArticle(this, "home");
    }


    @Override
    public void onResponse(List<TopStoriesArticles> results) {
        adapter.setResults(results);
    }

    @Override
    public void onFailure() {
    }

    private void setUpRecyclerView (){
        this.results=new ArrayList<>();
        this.adapter= new NewsAdapter(this.results);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
