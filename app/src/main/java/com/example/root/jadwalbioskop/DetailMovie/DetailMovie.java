package com.example.root.jadwalbioskop.DetailMovie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.root.jadwalbioskop.DetailMovie.ViewModel.DetailMovieVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.ActivityDetailMovieBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class DetailMovie extends GitsActivity<DetailMovieVM,ActivityDetailMovieBinding>{

    @Override
    protected int getToolbarId() {
        return R.id.toolbar_layout;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_detail_movie;
    }

    @Override
    public DetailMovieVM getViewModel() {
        return new DetailMovieVM(this);
    }

    @Override
    public void bindViewModel(ActivityDetailMovieBinding binding, DetailMovieVM viewModel) {
        binding.setVm(viewModel);
    }
}
