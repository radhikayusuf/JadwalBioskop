package com.example.root.jadwalbioskop.API.dao;

import java.util.List;

/**
 * Created by Varokah on 10/11/2016.
 */

public class MovieDao {
    public String status,kota,date;
    public List<DetailMovieDao> datas;

    public MovieDao(String status, String kota, String date, List<DetailMovieDao> datas) {
        this.status = status;
        this.kota = kota;
        this.date = date;
        this.datas = datas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<DetailMovieDao> getDatas() {
        return datas;
    }

    public void setDatas(List<DetailMovieDao> datas) {
        this.datas = datas;
    }
}
