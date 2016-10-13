package com.example.root.jadwalbioskop.Maps.ViewModel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentManager;
import android.util.Log;
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
    public static String kota, bioskop;

    public MapsActivityVM(final Context context, FragmentManager fragmentManager, String city, String bioskop1) {
        super(context);
        SupportMapFragment supportMapFragment = (SupportMapFragment) fragmentManager
                .findFragmentById(R.id.mapsDiActivity_Fragment);

        this.kota = city;
        this.bioskop = bioskop1;

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
                    geoLocate(context, bioskop, kota);
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
    private void LocationWithZoom(double lat, double lng, float zoom) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mgoogleMap.moveCamera(cam);

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
    public void geoLocate(Context context, final String location, final String kota) throws IOException {
        final String Location = location;
        final Geocoder gc = new Geocoder(context);
        List<Address> list;

        if(location.contains(kota)){
            list = gc.getFromLocationName(Location, 1);
        }else {
            list = gc.getFromLocationName(Location+" "+kota, 1);
        }
        Log.d("List.Size", String.valueOf(list.size()));

        if(list.size() != 0){
            Address address = list.get(0);
            double lat = address.getLatitude();
            double lng = address.getLongitude();
            LocationMarkWithZoom(lat,lng,18, location, kota);
        }else{
            Dialog dialog = new Dialog(mContext);
            dialog.setContentView(R.layout.dialog_not_found);
            dialog.show();
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    List<Address> list = null;
                    try {
                        list = gc.getFromLocationName(kota, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Address address = list.get(0);
                    double lat = address.getLatitude();
                    double lng = address.getLongitude();
                    LocationWithZoom(lat,lng,15);
                }
            });
        }


    }
}
