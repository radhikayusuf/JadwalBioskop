package com.example.root.jadwalbioskop.MovieList;

import com.example.root.jadwalbioskop.API.Movie.MovieResponse;
import com.example.root.jadwalbioskop.API.dao.DetailMovieDao;
import com.example.root.jadwalbioskop.API.dao.MovieDao;

import java.util.List;

import rx.Observable;

/**
 * Created by Varokah on 10/11/2016.
 */

public interface MovieRequest {
    Observable<MovieViewResponse> requestMovie(String id);

    class MovieViewResponse{
        public String status,kota,date;
        public List<DetailMovieDao> datas;

        public MovieViewResponse(String status, String kota, String date, List<DetailMovieDao> datas) {
            this.status = status;
            this.kota = kota;
            this.date = date;
            this.datas = datas;
        }
    }
}
