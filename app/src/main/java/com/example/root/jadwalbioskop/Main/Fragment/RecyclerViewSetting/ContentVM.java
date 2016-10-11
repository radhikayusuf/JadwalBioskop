package com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CardViewBindingAdapter;

import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.databinding.CardContentRowBinding;

import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 11/10/16.
 */

public class ContentVM extends GitsRowVM<KotaDao.DATA, CardContentRowBinding>{
    public String kota;

    public ContentVM(Context context, CardContentRowBinding binding, KotaDao.DATA data) {
        super(context, binding, data);
        kota = data.kota;
    }
}
