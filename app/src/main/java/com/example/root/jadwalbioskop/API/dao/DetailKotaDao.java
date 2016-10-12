package com.example.root.jadwalbioskop.API.dao;

/**
 * Created by root on 11/10/16.
 */

public class DetailKotaDao {
    public String id;
    public String kota;

    public DetailKotaDao(String id, String kota) {
        this.id = id;
        this.kota = kota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
