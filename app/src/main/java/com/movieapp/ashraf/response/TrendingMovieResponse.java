package com.movieapp.ashraf.response;

import com.google.gson.annotations.SerializedName;
import com.movieapp.ashraf.model.TrendingMovie;

import java.util.List;

public class TrendingMovieResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<TrendingMovie> trendingMovies;

    @SerializedName("total_pages")
    private String totalPages;

    @SerializedName("total_results")
    private String totalResults;

    public String getPage() {
        return page;
    }

    public List<TrendingMovie> getTrendingMovies() {
        return trendingMovies;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public String getTotalResults() {
        return totalResults;
    }
}
