package com.example.root.jadwalbioskop.Main;

import com.example.root.jadwalbioskop.API.Movie.MovieResponse;
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
        public List<data> datas;

        private class data {
            public String movie,poster,genre,duration;
            public List<jadwal> jadwals;

            private class jadwal{
                public String bioskop,harga;
                public List<String> jams;
            }
        }

        public MovieViewResponse(String status, String kota, String date, List<data> datas) {
            this.status = status;
            this.kota = kota;
            this.date = date;
            this.datas = datas;
        }
    }
}
