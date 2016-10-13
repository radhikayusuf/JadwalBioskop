package com.example.root.jadwalbioskop.DetailMovie.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.API.dao.JadwalDao;
import com.example.root.jadwalbioskop.DetailMovie.RecycleView.DetailAdapter;
import com.example.root.jadwalbioskop.Maps.MapsActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailMovieVM extends GitsVM {
    public ImageView.OnClickListener click;
    public String title, genre, duration;
    public String poster;
    public Button.OnClickListener openmaps;
    List<JadwalDao> jadwal = new ArrayList<>();
    public DetailAdapter detailAdapter;
    public LinearLayoutManager linearLayoutManager;
    private static Context ctx;

    public DetailMovieVM(Context context, DetailMovieDao dao) {
        super(context);
        poster = dao.getPoster();
        title = dao.getMovie();
        genre = dao.getGenre();
        duration = dao.getDuration();
        ctx = mContext;

        jadwal.addAll(dao.getJadwal());
        detailAdapter = new DetailAdapter(jadwal);
        linearLayoutManager = new LinearLayoutManager(context);
        detailAdapter.notifyDataSetChanged();

        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).finish();
            }
        };

        openmaps = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MapsActivity.class));
            }
        };
    }

    @BindingAdapter({"setBackground"})
    public static void setBackground(ImageView iv, String url){
        Picasso.with(ctx)
                .load(url)
                .fit()
                .into(iv);
    }
}
