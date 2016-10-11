package com.example.root.jadwalbioskop.API.Kota;

import android.util.Log;

import com.example.root.jadwalbioskop.API.ApiClient;
import com.example.root.jadwalbioskop.API.BaseRequest;
import com.example.root.jadwalbioskop.API.Kota.KotaResponse.DataBean;

import javax.inject.Singleton;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * Created by Varokah on 10/11/2016.
 */
@Singleton
public class KotaRequestImpl extends BaseRequest implements KotaRequest {

    @Override
    public Observable<DataBean> requestKota(){
        Observable<DataBean> observable = Observable.create(new OnSubscribe<DataBean>(){

                @Override
                public void call(Subscriber<? super DataBean> subscriber) {
                    try{
                        Thread.sleep(3000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    subscriber.onNext(new DataBean());
                    subscriber.onCompleted();
                }

            });
        apiClient.toString();
        return observable;
    }
}
