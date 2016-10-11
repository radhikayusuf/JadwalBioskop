package com.example.root.jadwalbioskop.API;

import com.example.root.jadwalbioskop.API.Kota.KotaResponse;
import com.example.root.jadwalbioskop.API.Movie.MovieResponse;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Varokah on 10/11/2016.
 */

public interface ApiInterface {
    @GET("/api/jadwal-bioskop")
    Observable<KotaResponse> kotaList();

    @GET("/api/jadwal-bioskop?id={id}")
    Observable<MovieResponse> movieList(@Path("id") String idKota);
}
