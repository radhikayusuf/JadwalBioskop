package com.example.root.jadwalbioskop.DetailMovie;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.DetailMovie.ViewModel.DetailMovieVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.ActivityDetailMovieBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class DetailMovie extends GitsActivity<DetailMovieVM,ActivityDetailMovieBinding>{
    Toolbar toolbar;
    @Override
    protected int getToolbarId() {
        return R.id.toolbar_detail;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_detail_movie;
    }


    @Override
    public DetailMovieVM getViewModel() {
        Intent i = getIntent();
        initToolbar();
        DetailMovieDao dao = (DetailMovieDao) i.getSerializableExtra("dao");
        return new DetailMovieVM(this, dao);
    }

    @Override
    public void bindViewModel(ActivityDetailMovieBinding binding, DetailMovieVM viewModel) {
        binding.setVm(viewModel);
    }
    public void initToolbar(){
        toolbar = (Toolbar)findViewById(getToolbarId());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void CheckProgress(){
        ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
