package com.example.root.jadwalbioskop.Main;

import com.example.root.jadwalbioskop.API.dao.KotaDao;

import java.util.List;

import rx.Observable;

/**
 * Created by Varokah on 10/11/2016.
 */

public interface KotaRequest {
    Observable<KotaViewResponse> requestKota();

    class KotaViewResponse {
        public String status;
        public List<KotaDao.DATA> data;

        public KotaViewResponse(String status, List<KotaDao.DATA> data) {
            this.status = status;
            this.data = data;

        }




    }
}
