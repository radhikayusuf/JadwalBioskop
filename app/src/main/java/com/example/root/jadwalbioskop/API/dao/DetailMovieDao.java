package com.example.root.jadwalbioskop.API.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailMovieDao implements Serializable{
    public String movie,poster,genre,duration;
    public List<JadwalDao> jadwal;

    public DetailMovieDao(String movie, String poster, String genre, String duration, List<JadwalDao> jadwal) {
        this.movie = movie;
        this.poster = poster;
        this.genre = genre;
        this.duration = duration;
        this.jadwal = jadwal;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<JadwalDao> getJadwal() {
        return jadwal;
    }

    public void setJadwal(List<JadwalDao> jadwal) {
        this.jadwal = jadwal;
    }
}
