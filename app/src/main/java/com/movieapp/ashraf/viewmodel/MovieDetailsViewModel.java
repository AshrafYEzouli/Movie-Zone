package com.movieapp.ashraf.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.movieapp.ashraf.model.MovieDetails;
import com.movieapp.ashraf.repository.MovieDetailsRepository;

public class MovieDetailsViewModel extends ViewModel {

    private MovieDetailsRepository movieDetailsRepository;

    public MovieDetailsViewModel(){
        this.movieDetailsRepository = new MovieDetailsRepository();
    }

    public LiveData<MovieDetails> getMovieDetails(int movieId){
        return movieDetailsRepository.getMovieDetails(movieId);
    }
}
