package com.example.root.jadwalbioskop.API.dao;

import java.util.List;

/**
 * Created by Varokah on 10/11/2016.
 */

public class KotaDao {
    public String status;
    public List<DetailKotaDao> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailKotaDao> getData() {
        return data;
    }

    public void setData(List<DetailKotaDao> data) {
        this.data = data;
    }

}
