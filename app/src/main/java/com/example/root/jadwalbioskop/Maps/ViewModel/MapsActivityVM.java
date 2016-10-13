package com.example.root.jadwalbioskop.Maps.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;

import com.example.root.jadwalbioskop.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 13/10/16.
 */

public class MapsActivityVM extends GitsVM{
    public ImageView.OnClickListener click;
    public String title = "Maps";

    public MapsActivityVM(Context context, FragmentManager fragmentManager) {
        super(context);
        SupportMapFragment supportMapFragment = (SupportMapFragment) fragmentManager
                .findFragmentById(R.id.mapsDiActivity_Fragment);


        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) mContext).finish();
            }
        };
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

            }
        });

    }
}
