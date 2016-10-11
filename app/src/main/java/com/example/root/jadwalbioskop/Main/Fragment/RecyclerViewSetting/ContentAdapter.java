package com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.CardContentRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 11/10/16.
 */

public class ContentAdapter extends GitsAdapter<KotaDao.DATA, ContentVM, CardContentRowBinding> {


    public ContentAdapter(List<KotaDao.DATA> collection) {
        super(collection);
    }

    @Override
    public ContentVM createViewModel(AppCompatActivity activity, CardContentRowBinding binding, KotaDao.DATA item, int position) {
        return new ContentVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.card_content_row;
    }

    @Override
    public void render(CardContentRowBinding binding, ContentVM viewModel, KotaDao.DATA item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(KotaDao.DATA data, int position) {

    }
}
