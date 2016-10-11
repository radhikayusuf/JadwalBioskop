package com.example.root.jadwalbioskop.Main.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.jadwalbioskop.Main.Fragment.ViewModel.SettingFragmentVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.FragmentSettingBinding;

import id.gits.mvvmcore.fragment.GitsFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends GitsFragment<SettingFragmentVM, FragmentSettingBinding> {


    @Override
    public int getResLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    public SettingFragmentVM getViewModel() {
        return new SettingFragmentVM(getActivity());
    }

    @Override
    public void bindViewModel(FragmentSettingBinding binding, SettingFragmentVM viewModel) {
        binding.setVm(viewModel);
    }
}
