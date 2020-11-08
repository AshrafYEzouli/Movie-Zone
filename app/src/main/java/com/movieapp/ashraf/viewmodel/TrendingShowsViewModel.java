package com.movieapp.ashraf.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.movieapp.ashraf.repository.TrendingMoviesRepository;
import com.movieapp.ashraf.response.TrendingMovieResponse;

public class TrendingShowsViewModel extends ViewModel {

    private TrendingMoviesRepository trendingMoviesRepository;

    public TrendingShowsViewModel(){
        this.trendingMoviesRepository = new TrendingMoviesRepository();
    }

    public LiveData<TrendingMovieResponse> getTrendingMovies(){
        return trendingMoviesRepository.getTrendingMovies();
    }
}
