package com.example.root.jadwalbioskop.DetailMovie.RecycleView;

import android.support.v7.app.AppCompatActivity;

import com.example.root.jadwalbioskop.API.dao.JadwalDao;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.CardDetailRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by Aqiel on 10/12/2016.
 */

public class DetailAdapter extends GitsAdapter<JadwalDao,DetailRowVM,CardDetailRowBinding> {
    public DetailAdapter(List<JadwalDao> collection) {
        super(collection);
    }

    @Override
    public DetailRowVM createViewModel(AppCompatActivity activity, CardDetailRowBinding binding, JadwalDao item, int position) {
        return new DetailRowVM(activity,binding,item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.card_detail_row;
    }

    @Override
    public void render(CardDetailRowBinding binding, DetailRowVM viewModel, JadwalDao item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(JadwalDao data, int position) {

    }
}
