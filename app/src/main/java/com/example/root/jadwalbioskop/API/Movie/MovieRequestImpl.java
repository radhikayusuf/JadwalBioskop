package com.example.root.jadwalbioskop.API.Movie;

import com.example.root.jadwalbioskop.API.BaseRequest;

import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Varokah on 10/11/2016.
 */
@Singleton
public class MovieRequestImpl extends BaseRequest implements MovieRequest{
    @Override
    public rx.Observable<MovieResponse.DataBean> requestMovie(){
        Observable<MovieResponse.DataBean> observable = Observable.create(new Observable.OnSubscribe<MovieResponse.DataBean>(){

            @Override
            public void call(Subscriber<? super MovieResponse.DataBean> subscriber) {
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                subscriber.onNext(new MovieResponse.DataBean());
                subscriber.onCompleted();
            }
        });
        apiClient.toString();
        return observable;
    }
}
