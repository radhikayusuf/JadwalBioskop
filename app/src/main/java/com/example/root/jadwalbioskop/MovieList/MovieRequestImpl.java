package com.example.root.jadwalbioskop.MovieList;

import android.util.Log;

import com.example.root.jadwalbioskop.API.BaseRequest;
import com.example.root.jadwalbioskop.API.Movie.MovieResponse;
import com.example.root.jadwalbioskop.API.dao.MovieDao;

import javax.inject.Singleton;

import rx.functions.Func1;

/**
 * Created by Varokah on 10/11/2016.
 */
@Singleton
public class MovieRequestImpl extends BaseRequest implements MovieRequest{
    @Override
    public rx.Observable<MovieViewResponse> requestMovie(String id){
        Log.d("Response id", id);
        return apiClient.getApiInterface().movieList(id).map(new Func1<MovieDao, MovieViewResponse>() {
            @Override
            public MovieViewResponse call(MovieDao movieDao) {
                Log.d("Responsenya ", movieDao.getKota());
                Log.d("Responsenya => ", movieDao.getData().get(0).getMovie());
                return new MovieViewResponse(movieDao.getStatus(),
                        movieDao.getKota(),
                        movieDao.getDate(),
                        movieDao.getData());
            }
        });


    }
}
