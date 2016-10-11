package com.example.root.jadwalbioskop.API.Kota;

import rx.Observable;

/**
 * Created by Varokah on 10/11/2016.
 */

public interface KotaRequest {
    Observable<KotaResponse.DataBean> requestKota();
}
