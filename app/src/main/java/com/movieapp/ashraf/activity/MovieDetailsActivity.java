package com.movieapp.ashraf.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.movieapp.ashraf.Constants;
import com.movieapp.ashraf.R;
import com.movieapp.ashraf.databinding.ActivityMovieDetailsBinding;
import com.movieapp.ashraf.model.MovieDetails;
import com.movieapp.ashraf.model.TrendingMovie;
import com.movieapp.ashraf.viewmodel.MovieDetailsViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.MessageFormat;

public class MovieDetailsActivity extends AppCompatActivity {

    private ActivityMovieDetailsBinding activityMovieDetailsBinding;
    private MovieDetailsViewModel movieDetailsViewModel;

    private Toolbar toolbar;
    private TrendingMovie trendingMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMovieDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        prepareViews();
    }

    private void prepareViews() {

        trendingMovie = (TrendingMovie) getIntent().getSerializableExtra("trendingMovie");

        toolbar = findViewById(R.id.movieDetailsToolbar);
        toolbar.setNavigationIcon(R.drawable.left_arrow);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        movieDetailsViewModel = new ViewModelProvider(this).get(MovieDetailsViewModel.class);
        getMovieDetails();
    }

    private void getMovieDetails() {
        int movieId = trendingMovie.getId();
        movieDetailsViewModel.getMovieDetails(movieId).observe(this, movieDetails -> {
            Picasso.get().load(movieDetails.getPosterPath()).noFade().into(activityMovieDetailsBinding.expandedImage, new Callback() {
                @Override
                public void onSuccess() {
                    activityMovieDetailsBinding.expandedImage.animate().setDuration(300).alpha(1f).start();
                }

                @Override
                public void onError(Exception e) {

                }
            });
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}