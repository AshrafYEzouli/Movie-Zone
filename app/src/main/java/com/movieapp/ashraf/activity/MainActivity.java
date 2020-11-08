package com.movieapp.ashraf.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.movieapp.ashraf.R;
import com.movieapp.ashraf.adapter.TrendingMoviesAdapter;
import com.movieapp.ashraf.adapter.TrendingShowsAdapter;
import com.movieapp.ashraf.databinding.ActivityMainBinding;
import com.movieapp.ashraf.listener.OnItemClickListener;
import com.movieapp.ashraf.model.TrendingMovie;
import com.movieapp.ashraf.viewmodel.TrendingShowsViewModel;
import com.movieapp.ashraf.viewmodel.TrendingMoviesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private ActivityMainBinding activityMainBinding;

    private TrendingShowsViewModel trendingShowsViewModel;
    private List<TrendingMovie> trendingMovies1 = new ArrayList<>();
    private TrendingMoviesAdapter trendingMoviesAdapter;

    private TrendingMoviesViewModel trendingMoviesViewModel;
    private List<TrendingMovie> trendingMovies = new ArrayList<>();
    TrendingShowsAdapter trendingShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void getMostPopularTVShows(){
        activityMainBinding.setIsLoading(true);
        trendingShowsViewModel.getTrendingMovies().observe(this, trendingMovieResponse -> {
            activityMainBinding.setIsLoading(false);
            if(trendingMovieResponse != null){
                if(trendingMovieResponse.getTrendingMovies() != null){
                    trendingMovies1.addAll(trendingMovieResponse.getTrendingMovies());
                    trendingMoviesAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void getTrendingMovies(){
        trendingMoviesViewModel.getTrendingMovies().observe(this, trendingMovieResponse -> {
            if(trendingMovieResponse != null){
                if(trendingMovieResponse.getTrendingMovies() != null){
                    trendingMovies.addAll(trendingMovieResponse.getTrendingMovies());
                    trendingShowsAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void init(){
        activityMainBinding.tvShowsRecyclerView.setHasFixedSize(true);
        activityMainBinding.tvShowsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        trendingShowsViewModel = new ViewModelProvider(this).get(TrendingShowsViewModel.class);
        trendingMoviesAdapter = new TrendingMoviesAdapter(trendingMovies1, this);
        activityMainBinding.tvShowsRecyclerView.setAdapter(trendingMoviesAdapter);

        activityMainBinding.trendingRecyclerView.setHasFixedSize(true);
        activityMainBinding.trendingRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        trendingMoviesViewModel = new ViewModelProvider(this).get(TrendingMoviesViewModel.class);
        trendingShowsAdapter = new TrendingShowsAdapter(trendingMovies);
        activityMainBinding.trendingRecyclerView.setAdapter(trendingShowsAdapter);

        getMostPopularTVShows();
        getTrendingMovies();
    }

    @Override
    public void onItemClick(TrendingMovie trendingMovie) {
        Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
        intent.putExtra("trendingMovie", trendingMovie);
        startActivity(intent);
    }
}