package com.example.root.jadwalbioskop;

import android.app.Application;

import com.example.root.jadwalbioskop.Dagger.Injector;

/**
 * Created by root on 11/10/16.
 */

public class JadwalBioskop extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.Initialize(this);
    }
}
