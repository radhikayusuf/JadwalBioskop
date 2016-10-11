package com.example.root.jadwalbioskop.Main.Fragment.ViewModel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.root.jadwalbioskop.API.Kota.KotaResponse;

import com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

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
