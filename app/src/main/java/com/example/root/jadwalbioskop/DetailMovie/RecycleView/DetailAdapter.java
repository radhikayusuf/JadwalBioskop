package com.example.root.jadwalbioskop.DetailMovie.RecycleView;

import android.support.v7.app.AppCompatActivity;

import com.example.root.jadwalbioskop.API.dao.JadwalDao;
import com.example.root.jadwalbioskop.databinding.CardDetailRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailAdapter extends GitsAdapter<JadwalDao,DetailRowVM,CardDetailRowBinding> {
    public DetailAdapter(List<JadwalDao> collection) {
        super(collection);
    }

    @Override
    public DetailRowVM createViewModel(AppCompatActivity activity, CardDetailRowBinding binding, JadwalDao item, int position) {
        return null;
    }

    @Override
    public int getLayoutRes() {
        return 0;
    }

    @Override
    public void render(CardDetailRowBinding binding, DetailRowVM viewModel, JadwalDao item) {

    }

    @Override
    public void onRowClick(JadwalDao data, int position) {

    }
}
