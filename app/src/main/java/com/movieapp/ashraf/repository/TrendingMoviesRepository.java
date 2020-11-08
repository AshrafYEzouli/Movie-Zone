package com.movieapp.ashraf.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.movieapp.ashraf.Constants;
import com.movieapp.ashraf.network.ApiService;
import com.movieapp.ashraf.network.MoviesApiClient;
import com.movieapp.ashraf.response.TrendingMovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingMoviesRepository {

    ApiService apiService;

    public TrendingMoviesRepository() {
        apiService = MoviesApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TrendingMovieResponse> getTrendingMovies(){
        MutableLiveData<TrendingMovieResponse> data = new MutableLiveData<>();
        apiService.getTrendingMovies(Constants.API_KEY).enqueue(new Callback<TrendingMovieResponse>() {
            @Override
            public void onResponse(Call<TrendingMovieResponse> call, Response<TrendingMovieResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TrendingMovieResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
