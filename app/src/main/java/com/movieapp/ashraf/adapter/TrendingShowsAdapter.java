package com.movieapp.ashraf.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.ashraf.R;
import com.movieapp.ashraf.databinding.ItemContainerTrendingShowsBinding;
import com.movieapp.ashraf.model.TrendingMovie;

import java.util.List;

public class TrendingShowsAdapter extends RecyclerView.Adapter<TrendingShowsAdapter.TrendingMoviesViewHolder> {

    private List<TrendingMovie> trendingMovies;
    private LayoutInflater layoutInflater;

    public TrendingShowsAdapter(List<TrendingMovie> trendingMovies) {
        this.trendingMovies = trendingMovies;
    }

    @NonNull
    @Override
    public TrendingMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ItemContainerTrendingShowsBinding trendingShowsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_container_trending_shows, parent, false);
        return new TrendingMoviesViewHolder(trendingShowsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingMoviesViewHolder holder, int position) {
        holder.bindTrendingMovies(trendingMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return trendingMovies.size();
    }

    public static class TrendingMoviesViewHolder extends RecyclerView.ViewHolder{

        ItemContainerTrendingShowsBinding itemContainerTrendingShowsBinding;

        public TrendingMoviesViewHolder(@NonNull ItemContainerTrendingShowsBinding itemContainerTrendingShowsBinding) {
            super(itemContainerTrendingShowsBinding.getRoot());
            this.itemContainerTrendingShowsBinding = itemContainerTrendingShowsBinding;
        }

        public void bindTrendingMovies(TrendingMovie trendingMovie){
            itemContainerTrendingShowsBinding.setTrendingMovie(trendingMovie);
            itemContainerTrendingShowsBinding.executePendingBindings();
        }
    }
}
