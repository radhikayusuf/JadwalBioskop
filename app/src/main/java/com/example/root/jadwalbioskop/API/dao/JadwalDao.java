package com.example.root.jadwalbioskop.API.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Varokah on 10/12/2016.
 */

public class JadwalDao implements Serializable{
    public String bioskop,harga;
    public List<String> jam;

    public JadwalDao(String bioskop, String harga, List<String> jam) {
        this.bioskop = bioskop;
        this.harga = harga;
        this.jam = jam;
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

    public List<String> getJam() {
        return jam;
    }

    public void setJam(List<String> jam) {
        this.jam = jam;
    }
}
