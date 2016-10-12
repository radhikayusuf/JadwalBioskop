package com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.CardViewBindingAdapter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.jadwalbioskop.API.dao.DetailKotaDao;
import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.databinding.CardContentRowBinding;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;
import java.util.Observable;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by root on 11/10/16.
 */

public class ContentVM extends GitsRowVM<DetailKotaDao, CardContentRowBinding>{
    private static Context context;
    public String kota;
    public String id;
    public String no;
    public String url;
    public View.OnClickListener click;

    public ContentVM(AppCompatActivity activity, CardContentRowBinding binding, DetailKotaDao item, Integer posisi) {
        super(activity, binding, item);
        kota = item.kota;
        no = String.valueOf(posisi);
        url = "http://www.morefoods.hol.es/Kota/"+kota+".jpg";
        id = item.getId();
        context = mContext;
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, kota +" "+ id, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @BindingAdapter({"setBG"})
    public static void setBG(CardView cardView, String no){
        int a = 0;
        a = Integer.parseInt(no);
//        System.out.println("HasilParse"+a);

        if(a%2==0){
            cardView.setBackgroundColor(Color.WHITE);
        }else{
            cardView.setBackgroundColor(Color.rgb(245,245,245));
        }
    }

    @BindingAdapter({"setImage"})
    public static void setImage(final LinearLayout iv, String url){
//        System.out.println("URLnya "+url);
//        Picasso.with(context)
//                .load(url)
//                .into(new Target() {
//                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//                    @Override
//                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                        iv.setBackground(new BitmapDrawable(context.getResources(), bitmap));
//                    }
//
//                    @Override
//                    public void onBitmapFailed(Drawable errorDrawable) {
//
//                    }
//
//                    @Override
//                    public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//                    }
//                });
    }
}
