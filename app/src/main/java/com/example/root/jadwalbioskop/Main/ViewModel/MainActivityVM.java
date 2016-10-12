package com.example.root.jadwalbioskop.Main.ViewModel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.JadwalBioskop;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.API.Kota.KotaResponse;
import com.example.root.jadwalbioskop.Dagger.Injector;
import com.example.root.jadwalbioskop.Main.Adapter.ViewPagerAdapter;
import com.example.root.jadwalbioskop.Main.Fragment.ContentFragment;
import com.example.root.jadwalbioskop.Main.Fragment.SettingFragment;
import com.example.root.jadwalbioskop.Main.Search.ObservableString;
import com.example.root.jadwalbioskop.Main.Search.TextWatcherAdapter;
import com.example.root.jadwalbioskop.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import javax.inject.Inject;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 11/10/16.
 */

public class MainActivityVM extends GitsVM{

    public View.OnClickListener click;
    private static Context ctx;
    public ViewPagerAdapter viewPagerAdapter;
    public HashMap<String,String> url_maps = new HashMap<String, String>();

    public MainActivityVM(Context context, FragmentManager fragmentManager) {
        super(context);

        url_maps.put("Civil War", "http://media.comicbook.com/2016/05/captain-america-civil-war-02082016-182755.png");
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.addFragment(new ContentFragment());
        viewPagerAdapter.addFragment(new SettingFragment());
        ctx = context;
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"viewpager",Toast.LENGTH_SHORT).show();
            }
        };
    }


    @BindingAdapter({"setAdapter"})
    public static void setAdapter(ViewPager viewPager, ViewPagerAdapter viewPagerAdapter){
        viewPager.setAdapter(viewPagerAdapter);
    }

    @BindingAdapter({"setBackground"})
    public static void setBackground(SliderLayout sliderLayout, HashMap<String, String> url){
        for(String img : url.keySet()){
            TextSliderView textSliderView = new TextSliderView(ctx);
            textSliderView
                    .description(img)
                    .image(url.get(img))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

            sliderLayout.addSlider(textSliderView);
        }
    }
}
