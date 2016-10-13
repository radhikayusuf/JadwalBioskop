package com.example.root.jadwalbioskop.Maps.ViewModel;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import com.example.root.jadwalbioskop.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class MapsVM extends GitsVM implements OnMapReadyCallback {
    GoogleMap googleMap;
    Marker marker;
    FragmentManager mfragmentManager;
    String map;
    Context con;

    public MapsVM(Context context, String maps, FragmentManager fragmentManager) {
        super(context);
        if(googleServicesAvailable()){
            con = context;
            map = maps;
            mfragmentManager = fragmentManager;
            initMap();
        }else {
            ((Activity)context).finish();
        }
    }

    private void initMap() {
        MapFragment map = (MapFragment) mfragmentManager.findFragmentById(R.id.fragment_map);
        map.getMapAsync(this);
    }

    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(mContext);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }else if(api.isUserResolvableError(isAvailable)){

        }else {
            Log.e("googleServiceAvailable","Can't Connect to Play Service");
        }
        return false;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        try {
            geoLocate(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
    }
    private void LocationMarkWithZoom(double lat, double lng, float zoom) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        googleMap.moveCamera(cam);

        setMarker(lat, lng);
    }

    private void setMarker(double lat, double lng) {
        if(marker != null){
            marker.remove();
        }

        MarkerOptions markerOptions = new MarkerOptions()
                .title("Bioskop") // title marker
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))//change marker icon
                .position(new LatLng(lat,lng));
        marker = googleMap.addMarker(markerOptions);
    }

    public void geoLocate(String location) throws IOException {
        String Location = location;
        Geocoder gc = new Geocoder(con);
        List<Address> list = gc.getFromLocationName(Location,1);
        Address address = list.get(0);
        double lat = address.getLatitude();
        double lng = address.getLongitude();

        LocationMarkWithZoom(lat,lng,15);

    }
}
