package com.example.root.jadwalbioskop.Main;

import com.example.root.jadwalbioskop.API.ApiInterface;
import com.example.root.jadwalbioskop.API.BaseRequest;
import com.example.root.jadwalbioskop.API.Kota.KotaResponse;
import com.example.root.jadwalbioskop.API.dao.KotaDao;

import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Varokah on 10/11/2016.
 */
@Singleton
public class KotaRequestImpl extends BaseRequest implements KotaRequest {

    ApiInterface mApi;
    @Override
    public Observable<KotaViewResponse> requestKota(){

        return apiClient.getApiInterface().kotaList().map(new Func1<KotaDao, KotaViewResponse>() {
            @Override
            public KotaViewResponse call(KotaDao kotaDao) {
                return new KotaViewResponse(kotaDao.status,kotaDao.data);
            }
        });
    }
}
