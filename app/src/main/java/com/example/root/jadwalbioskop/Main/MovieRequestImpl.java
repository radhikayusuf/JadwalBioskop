package com.example.root.jadwalbioskop.Main;

import com.example.root.jadwalbioskop.API.BaseRequest;
import com.example.root.jadwalbioskop.API.Movie.MovieResponse;
import com.example.root.jadwalbioskop.API.dao.MovieDao;

import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Varokah on 10/11/2016.
 */
@Singleton
public class MovieRequestImpl extends BaseRequest implements MovieRequest{
    @Override
    public rx.Observable<MovieViewResponse> requestMovie(String id){
        return apiClient.getApiInterface().movieList(id).map(new Func1<MovieDao, MovieViewResponse>() {
            @Override
            public MovieViewResponse call(MovieDao movieResponse) {
                return new MovieViewResponse(movieResponse.status,movieResponse.kota,movieResponse.date,movieResponse.datas);
            }
        });
    }
}
