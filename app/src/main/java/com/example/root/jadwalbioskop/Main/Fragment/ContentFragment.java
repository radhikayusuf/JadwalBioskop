package com.example.root.jadwalbioskop.Main.Fragment;


import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.jadwalbioskop.Main.Fragment.ViewModel.ContentFragmentVM;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.FragmentContentBinding;

import id.gits.mvvmcore.fragment.GitsFragment;
import id.gits.mvvmcore.viewmodel.GitsVM;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends GitsFragment<ContentFragmentVM, FragmentContentBinding> {


    @Override
    public int getResLayout() {
        return R.layout.fragment_content;
    }

    @Override
    public ContentFragmentVM getViewModel() {
        return new ContentFragmentVM(getActivity());
    }

    @Override
    public void bindViewModel(FragmentContentBinding binding, ContentFragmentVM viewModel) {
        binding.setVm(viewModel);
    }
}
