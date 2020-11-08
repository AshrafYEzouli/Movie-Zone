package com.movieapp.ashraf.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.movieapp.ashraf.Constants;
import com.movieapp.ashraf.model.MovieDetails;
import com.movieapp.ashraf.network.ApiService;
import com.movieapp.ashraf.network.MoviesApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsRepository {

    ApiService apiService;

    public MovieDetailsRepository() {
        apiService = MoviesApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<MovieDetails> getMovieDetails(int movieId){
        MutableLiveData<MovieDetails> data = new MutableLiveData<>();
        apiService.getMovieDetails(movieId, Constants.API_KEY).enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
