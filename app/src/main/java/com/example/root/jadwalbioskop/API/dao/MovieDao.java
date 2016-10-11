package com.example.root.jadwalbioskop.API.dao;

import java.util.List;

/**
 * Created by Varokah on 10/11/2016.
 */

public class MovieDao {
    public String status,kota,date;
    public List<data> datas;

    public class data {
        public String movie,poster,genre,duration;
        public List<jadwal> jadwals;

        public class jadwal{
            public String bioskop,harga;
            public List<String> jams;
        }
    }

    public MovieDao(String status, String kota, String date, List<data> datas) {
        this.status = status;
        this.kota = kota;
        this.date = date;
        this.datas = datas;
    }
}
