package com.example.root.jadwalbioskop.MovieList;

import android.content.Intent;

import com.example.root.jadwalbioskop.MovieList.ViewModel.MovieListVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.ActivityMovieListBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class MovieList extends GitsActivity<MovieListVM, ActivityMovieListBinding>{
    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_movie_list;
    }

    @Override
    public MovieListVM getViewModel() {
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        return new MovieListVM(this, id);
    }

    @Override
    public void bindViewModel(ActivityMovieListBinding binding, MovieListVM viewModel) {
        binding.setVm(viewModel);
    }
}
