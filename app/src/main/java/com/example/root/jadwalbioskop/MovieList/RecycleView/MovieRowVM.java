package com.example.root.jadwalbioskop.MovieList.RecycleView;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.widget.ImageView;

import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.databinding.MovieRowBinding;
import com.squareup.picasso.Picasso;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class MovieRowVM extends GitsRowVM<DetailMovieDao, MovieRowBinding> {
    private static Context ctx;
    public String title, url;

    public MovieRowVM(Context context, MovieRowBinding binding, DetailMovieDao data) {
        super(context, binding, data);
        title = data.getMovie();
        ctx = context;
        url = data.getPoster();
    }

    @BindingAdapter({"setBackground"})
    public static void setBackground(ImageView iv, String url){
        Picasso.with(ctx)
                .load(url)
                .into(iv);
    }
}
