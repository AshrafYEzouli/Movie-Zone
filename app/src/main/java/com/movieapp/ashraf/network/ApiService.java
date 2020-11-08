package com.movieapp.ashraf.network;

import com.movieapp.ashraf.model.MovieDetails;
import com.movieapp.ashraf.response.TrendingMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("trending/all/day")
    Call<TrendingMovieResponse> getTrendingMovies(@Query("api_key") String apiKey);

    @GET("movie/{movieId}")
    Call<MovieDetails> getMovieDetails(@Path(value = "movieId", encoded = true) int movieId, @Query("api_key") String apiKey);
}
