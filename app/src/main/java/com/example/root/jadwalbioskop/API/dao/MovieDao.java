package com.example.root.jadwalbioskop.API.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Varokah on 10/11/2016.
 */

public class MovieDao implements Serializable{
    public String status,kota,date;
    public List<DetailMovieDao> data;

    public MovieDao(String status, String kota, String date, List<DetailMovieDao> data) {
        this.status = status;
        this.kota = kota;
        this.date = date;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatu(String status) {
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

    public List<DetailMovieDao> getData() {
        return data;
    }

    public void setData(List<DetailMovieDao> data) {
        this.data = data;
    }
}
