package com.movieapp.ashraf.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.ashraf.R;
import com.movieapp.ashraf.databinding.ItemContainerTrendingMoviesBinding;
import com.movieapp.ashraf.databinding.ItemContainerTrendingShowsBinding;
import com.movieapp.ashraf.listener.OnItemClickListener;
import com.movieapp.ashraf.model.TrendingMovie;

import java.util.List;

public class TrendingMoviesAdapter extends RecyclerView.Adapter<TrendingMoviesAdapter.TrendingMoviesViewHolder> {

    private List<TrendingMovie> trendingMovies;
    private LayoutInflater layoutInflater;
    private OnItemClickListener listener;

    public TrendingMoviesAdapter(List<TrendingMovie> trendingMovies, OnItemClickListener listener) {
        this.trendingMovies = trendingMovies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TrendingMoviesAdapter.TrendingMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ItemContainerTrendingMoviesBinding trendingShowsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_container_trending_movies, parent, false);
        return new TrendingMoviesAdapter.TrendingMoviesViewHolder(trendingShowsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingMoviesAdapter.TrendingMoviesViewHolder holder, int position) {
        holder.bindTrendingMovies(trendingMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return trendingMovies.size();
    }

    class TrendingMoviesViewHolder extends RecyclerView.ViewHolder{

        ItemContainerTrendingMoviesBinding itemContainerTrendingMoviesBinding;

        public TrendingMoviesViewHolder(@NonNull ItemContainerTrendingMoviesBinding itemContainerTrendingShowsBinding) {
            super(itemContainerTrendingShowsBinding.getRoot());
            this.itemContainerTrendingMoviesBinding = itemContainerTrendingShowsBinding;
        }

        public void bindTrendingMovies(TrendingMovie trendingMovie){
            itemContainerTrendingMoviesBinding.setTrendingMovie(trendingMovie);
            itemContainerTrendingMoviesBinding.executePendingBindings();
            itemContainerTrendingMoviesBinding.getRoot().setOnClickListener(v -> listener.onItemClick(trendingMovie));
        }
    }
}
