package com.example.root.jadwalbioskop.API.Movie;

import rx.Observable;

/**
 * Created by Varokah on 10/11/2016.
 */

public interface MovieRequest {
    Observable<MovieResponse.DataBean> requestMovie();
}
