package com.movieapp.ashraf.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TrendingMovie implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w500/" + posterPath;
    }

    public String getOverview() {
        return overview;
    }
}
