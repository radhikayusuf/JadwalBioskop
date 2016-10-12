package com.example.root.jadwalbioskop.DetailMovie.RecycleView;

import android.content.Context;

import com.example.root.jadwalbioskop.API.dao.JadwalDao;
import com.example.root.jadwalbioskop.databinding.CardDetailRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailRowVM extends GitsRowVM<JadwalDao,CardDetailRowBinding>{
    public DetailRowVM(Context context, CardDetailRowBinding binding, JadwalDao data) {
        super(context, binding, data);
    }
}
