package com.example.root.jadwalbioskop.Main.Fragment.ViewModel;

import android.content.Context;
import android.databinding.tool.util.L;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.root.jadwalbioskop.API.Kota.KotaRequest;
import com.example.root.jadwalbioskop.API.Kota.KotaResponse;

import com.example.root.jadwalbioskop.Dagger.Injector;
import com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting.ContentAdapter;
import com.google.common.util.concurrent.AbstractScheduledService;

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
    List<KotaResponse.DataBean> mDataKota = new ArrayList<>();
    public LinearLayoutManager bGridLayoutManager;

    public ContentFragmentVM(Context context) {
        super(context);



        rcAppAdapter = new ContentAdapter(mDataKota);
        bGridLayoutManager = new LinearLayoutManager(mContext);



    }
}
