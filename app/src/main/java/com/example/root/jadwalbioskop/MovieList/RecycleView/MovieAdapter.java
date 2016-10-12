package com.example.root.jadwalbioskop.MovieList.RecycleView;

import android.support.v7.app.AppCompatActivity;

import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.API.dao.MovieDao;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.MovieRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by Varokah on 10/12/2016.
 */

public class MovieAdapter extends GitsAdapter<DetailMovieDao, MovieRowVM, MovieRowBinding> {


    public MovieAdapter(List<DetailMovieDao> collection) {
        super(collection);
    }

    @Override
    public MovieRowVM createViewModel(AppCompatActivity activity, MovieRowBinding binding, DetailMovieDao item, int position) {
        return new MovieRowVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.movie_row;
    }

    @Override
    public void render(MovieRowBinding binding, MovieRowVM viewModel, DetailMovieDao item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(DetailMovieDao data, int position) {

    }
}
