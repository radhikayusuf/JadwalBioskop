package com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.root.jadwalbioskop.API.dao.DetailKotaDao;
import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.MovieList.MovieList;
import com.example.root.jadwalbioskop.R;
import com.example.root.jadwalbioskop.databinding.CardContentRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 11/10/16.
 */

public class ContentAdapter extends GitsAdapter<DetailKotaDao, ContentVM, CardContentRowBinding> {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public ContentAdapter(List<DetailKotaDao> collection) {
        super(collection);
    }

    @Override
    public ContentVM createViewModel(AppCompatActivity activity, CardContentRowBinding binding, DetailKotaDao item, int position) {
        return new ContentVM(activity, binding, item, position);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.card_content_row;
    }

    @Override
    public void render(CardContentRowBinding binding, ContentVM viewModel, DetailKotaDao item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(DetailKotaDao data, int position) {
        //Toast.makeText(mContext, mCollection.get(position).getKota() +" "+ mCollection.get(position).getId(), Toast.LENGTH_SHORT).show();
        //Log.d("Hello1","");
        sharedPreferences = mContext.getSharedPreferences("data", 0);
        editor = sharedPreferences.edit();
        editor.putString("kota", mCollection.get(position).getKota());
        editor.commit();

        Intent i = new Intent(mContext, MovieList.class);
        i.putExtra("id", data.getId());
        i.putExtra("title", data.getKota());
        mContext.startActivity(i);
    }

}
