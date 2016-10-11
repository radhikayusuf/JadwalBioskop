package com.example.root.jadwalbioskop.API.Kota;

import java.util.List;

/**
 * Created by Varokah on 10/11/2016.
 */

public class KotaResponse {

    public String status;

    public List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean {
        public DataBean(String id, String kota) {
            this.id = id;
            this.kota = kota;
        }

        public String id;
        public String kota;

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
}
