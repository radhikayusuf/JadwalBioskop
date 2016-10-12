package com.example.root.jadwalbioskop.API;

import com.example.root.jadwalbioskop.API.Kota.KotaResponse;
import com.example.root.jadwalbioskop.API.Movie.MovieResponse;
import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.API.dao.MovieDao;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Varokah on 10/11/2016.
 */

public interface ApiInterface {
    @GET("/api/jadwal-bioskop")
    Observable<KotaDao> kotaList();

    @GET("/api/jadwal-bioskop")
    Observable<MovieDao> movieList(@Query("id") String idKota);
}
