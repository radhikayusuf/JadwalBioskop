package com.example.root.jadwalbioskop.Main.Fragment.ViewModel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.root.jadwalbioskop.API.Kota.KotaResponse;

import com.example.root.jadwalbioskop.API.dao.DetailKotaDao;
import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.Dagger.Injector;
import com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting.ContentAdapter;
import com.example.root.jadwalbioskop.Main.KotaRequest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 11/10/16.
 */

public class ContentFragmentVM extends GitsVM {



    public ContentAdapter rcAppAdapter;
    List<KotaRequest.KotaViewResponse> mDataKota;
    List<DetailKotaDao> detailKotaDaos = new ArrayList<>();
    public LinearLayoutManager bGridLayoutManager;

    @Inject
    KotaRequest kotaRequest;

    public ContentFragmentVM(Context context) {
        super(context);
        Injector.component.Inject(this);

        rcAppAdapter = new ContentAdapter(detailKotaDaos);
        bGridLayoutManager = new LinearLayoutManager(mContext);

        kotaRequest.requestKota()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<KotaRequest.KotaViewResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.e( "onCompleted: ","complete" );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e( "onError: ",e.toString() );

                    }

                    @Override
                    public void onNext(KotaRequest.KotaViewResponse kotaViewResponse) {
                        detailKotaDaos.addAll(kotaViewResponse.datas);
                        //mDataKota.add(kotaViewResponse);
                        rcAppAdapter.notifyDataSetChanged();
                    }
                });
    }


}
