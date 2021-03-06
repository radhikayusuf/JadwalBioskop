package com.example.root.jadwalbioskop.Maps;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.jadwalbioskop.Maps.ViewModel.MapsActivityVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.ActivityMapsBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class MapsActivity extends GitsActivity<MapsActivityVM, ActivityMapsBinding> {


    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_maps;
    }

    @Override
    public MapsActivityVM getViewModel() {
        Intent i = getIntent();
        String kota = i.getStringExtra("kota");
        String bioskop = i.getStringExtra("bioskop");
        return new MapsActivityVM(this, getSupportFragmentManager(), kota, bioskop);
    }

    @Override
    public void bindViewModel(ActivityMapsBinding binding, MapsActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
