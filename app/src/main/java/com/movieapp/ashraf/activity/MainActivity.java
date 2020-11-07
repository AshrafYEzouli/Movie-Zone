package com.movieapp.ashraf.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.movieapp.ashraf.R;
import com.movieapp.ashraf.adapter.TVShowsAdapter;
import com.movieapp.ashraf.databinding.ActivityMainBinding;
import com.movieapp.ashraf.model.TVShow;
import com.movieapp.ashraf.viewmodel.MostPopularTVShowsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MostPopularTVShowsViewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private List<TVShow> tvShows = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void getMostPopularTVShows(){
        activityMainBinding.setIsLoading(true);
        viewModel.getMostPopularTVShows(0).observe(this, mostPopularTVShows -> {
            activityMainBinding.setIsLoading(false);
            if(mostPopularTVShows != null){
                if(mostPopularTVShows.getTvShows() != null){
                    tvShows.addAll(mostPopularTVShows.getTvShows());
                    tvShowsAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void init(){
        activityMainBinding.tvShowsRecyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        tvShowsAdapter = new TVShowsAdapter(tvShows);
        activityMainBinding.tvShowsRecyclerView.setAdapter(tvShowsAdapter);
        getMostPopularTVShows();
    }
}