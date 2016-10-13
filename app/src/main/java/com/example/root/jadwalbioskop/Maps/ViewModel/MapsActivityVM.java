package com.example.root.jadwalbioskop.Maps.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;

import com.example.root.jadwalbioskop.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 13/10/16.
 */

public class MapsActivityVM extends GitsVM{
    public ImageView.OnClickListener click;
    public String title = "Maps";
    public static GoogleMap mgoogleMap;
    public Marker marker;

    public MapsActivityVM(final Context context, FragmentManager fragmentManager) {
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
                mgoogleMap = googleMap;
                try {
                    geoLocate(context,"BIP", "Bandung");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void LocationMarkWithZoom(double lat, double lng, float zoom, String bioskop, String kota) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mgoogleMap.moveCamera(cam);
        setMarker(lat, lng, bioskop, kota);

    }
    private void setMarker(double lat, double lng, String bioskop, String Kota) {
        if(marker != null){
            marker.remove();
        }

        MarkerOptions markerOptions = new MarkerOptions()
                .title(bioskop)
                .snippet(Kota)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))//
                .position(new LatLng(lat,lng));
        marker = mgoogleMap.addMarker(markerOptions);

    }
    public void geoLocate(Context context,String location, String kota) throws IOException {
        String Location = location;
        Geocoder gc = new Geocoder(context);


        List<Address> list = gc.getFromLocationName(Location+" "+kota, 1);
        Address address = list.get(0);
        double lat = address.getLatitude();
        double lng = address.getLongitude();
        LocationMarkWithZoom(lat,lng,18, location, kota);

    }
}
