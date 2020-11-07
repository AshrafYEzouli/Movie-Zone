package com.movieapp.ashraf.response;

import com.movieapp.ashraf.model.TVShow;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVShowsResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("pages")
    private String totalPages;

    @SerializedName("tv_shows")
    private List<TVShow> tvShows;

    public String getPage() {
        return page;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public List<TVShow> getTvShows() {
        return tvShows;
    }
}
