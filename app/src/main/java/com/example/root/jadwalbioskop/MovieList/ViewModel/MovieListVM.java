package com.example.root.jadwalbioskop.MovieList.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.root.jadwalbioskop.API.Movie.MovieResponse;
import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.API.dao.MovieDao;
import com.example.root.jadwalbioskop.Dagger.Injector;
import com.example.root.jadwalbioskop.MovieList.MovieList;
import com.example.root.jadwalbioskop.MovieList.MovieRequest;
import com.example.root.jadwalbioskop.MovieList.RecycleView.MovieAdapter;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Varokah on 10/12/2016.
 */

public class MovieListVM extends GitsVM {

    @Inject
    MovieRequest movieRequest;
    public ImageView.OnClickListener click;
    List<DetailMovieDao> jadwalBeen = new ArrayList<>();
    public MovieAdapter movieAdapter;
    public GridLayoutManager gridLayoutManager;
    public String title = "";

    public MovieListVM(Context context, String id, String title) {
        super(context);
        Injector.component.InjectMovie(this);

        this.title = title;

        Log.d("IDnya : ",id);
        movieAdapter = new MovieAdapter(jadwalBeen);
        gridLayoutManager = new GridLayoutManager(context, 2);

        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) mContext).finish();
            }
        };

        movieRequest.requestMovie(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<MovieRequest.MovieViewResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.e("Completenya ","aja");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Log.e("Errornya ",e.getMessage());
                    }

                    @Override
                    public void onNext(MovieRequest.MovieViewResponse movieViewResponse) {
                        jadwalBeen.addAll(movieViewResponse.datas);
                        movieAdapter.notifyDataSetChanged();
                    }
                });

    }


}
