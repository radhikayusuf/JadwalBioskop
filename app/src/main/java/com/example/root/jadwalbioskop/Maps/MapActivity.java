package com.example.root.jadwalbioskop.Maps;

import android.content.Intent;

import com.example.root.jadwalbioskop.Maps.ViewModel.MapsVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.ActivityMapsBinding;

import id.gits.mvvmcore.activity.GitsActivity;

/**
 * Created by Varokah on 10/12/2016.
 */

public class MapActivity extends GitsActivity<MapsVM,ActivityMapsBinding> {
    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_maps;
    }

    @Override
    public MapsVM getViewModel() {
        Intent in = getIntent();
        //return new MapsVM(this,in.getExtras().getString("maps").toString(), getFragmentManager());
        return new MapsVM(this,"BEC XXI", getFragmentManager());
    }

    @Override
    public void bindViewModel(ActivityMapsBinding binding, MapsVM viewModel) {
        binding.setVm(viewModel);
    }
}
