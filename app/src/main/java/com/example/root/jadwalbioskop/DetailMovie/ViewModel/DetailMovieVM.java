package com.example.root.jadwalbioskop.DetailMovie.ViewModel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.API.dao.JadwalDao;
import com.example.root.jadwalbioskop.DetailMovie.RecycleView.DetailAdapter;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailMovieVM extends GitsVM {
    public String title, genre, duration;
    public Button.OnClickListener openmaps;
    List<JadwalDao> jadwal = new ArrayList<>();
    public DetailAdapter detailAdapter;
    public LinearLayoutManager linearLayoutManager;

    public DetailMovieVM(Context context, DetailMovieDao dao) {
        super(context);
        title = dao.getMovie();
        genre = dao.getGenre();
        duration = dao.getDuration();

        jadwal.addAll(dao.getJadwal());
        detailAdapter = new DetailAdapter(jadwal);
        linearLayoutManager = new LinearLayoutManager(context);
        detailAdapter.notifyDataSetChanged();

        openmaps = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }
}
