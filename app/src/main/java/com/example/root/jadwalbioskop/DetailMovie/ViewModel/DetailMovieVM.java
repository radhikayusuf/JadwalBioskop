package com.example.root.jadwalbioskop.DetailMovie.ViewModel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailMovieVM extends GitsVM {
    public String title, genre, duration;
    public Button.OnClickListener openmaps;
    public DetailMovieVM(Context context, DetailMovieDao dao) {
        super(context);
        title = dao.getMovie();
        genre = dao.getGenre();
        duration = dao.getDuration();


        openmaps = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }
}
