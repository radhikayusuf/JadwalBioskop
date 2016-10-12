package com.example.root.jadwalbioskop.API.dao;

import java.util.List;

/**
 * Created by Varokah on 10/12/2016.
 */

public class JadwalDao {
    public String bioskop,harga;
    public List<String> jams;

    public JadwalDao(String bioskop, String harga, List<String> jams) {
        this.bioskop = bioskop;
        this.harga = harga;
        this.jams = jams;
    }

    public String getBioskop() {
        return bioskop;
    }

    public void setBioskop(String bioskop) {
        this.bioskop = bioskop;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public List<String> getJams() {
        return jams;
    }

    public void setJams(List<String> jams) {
        this.jams = jams;
    }
}
