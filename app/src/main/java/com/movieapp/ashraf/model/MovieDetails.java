package com.movieapp.ashraf.model;

import com.google.gson.annotations.SerializedName;
import com.movieapp.ashraf.Constants;

public class MovieDetails {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_title")
    private String originalTitle;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return Constants.NETWORK_IMAGE_BASE_URL + posterPath;
    }
}
