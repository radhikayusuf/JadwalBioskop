package com.example.root.jadwalbioskop.Main.ViewModel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.JadwalBioskop;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.API.Kota.KotaResponse;
import com.example.root.jadwalbioskop.Dagger.Injector;
import com.example.root.jadwalbioskop.Main.Adapter.ViewPagerAdapter;
import com.example.root.jadwalbioskop.Main.Fragment.ContentFragment;
import com.example.root.jadwalbioskop.Main.Fragment.SettingFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 11/10/16.
 */

public class MainActivityVM extends GitsVM{

    @Inject
    KotaRequest kotaRequest;

    public String bg = "http://media.comicbook.com/2016/05/captain-america-civil-war-02082016-182755.png";
    private static Context ctx;
    public ViewPagerAdapter viewPagerAdapter;

    public MainActivityVM(Context context, FragmentManager fragmentManager) {
        super(context);

        Injector.component.Inject(this);

        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFragment(new ContentFragment());
        viewPagerAdapter.addFragment(new SettingFragment());
        ctx = context;


        kotaRequest.requestKota()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<KotaRequest.KotaViewResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.e( "onCompleted: ","complete" );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e( "onError: ",e.toString() );

                    }

                    @Override
                    public void onNext(KotaRequest.KotaViewResponse kotaViewResponse) {
                        Log.e("onNext: ", kotaViewResponse.status);
                        Log.e("onNext: ", kotaViewResponse.data.get(0).kota);

                    }
                });

    }


    @BindingAdapter({"setAdapter"})
    public static void setAdapter(ViewPager viewPager, ViewPagerAdapter viewPagerAdapter){
        viewPager.setAdapter(viewPagerAdapter);
    }

    @BindingAdapter({"setBackground"})
    public static void setBackground(ImageView imageView, String url){
        Picasso.with(ctx)
                .load(url)
                .into(imageView);
    }



}
