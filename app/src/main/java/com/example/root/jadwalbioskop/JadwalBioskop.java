package com.example.root.jadwalbioskop;

import android.app.Application;

import com.example.root.jadwalbioskop.Dagger.Injector;
import com.google.gson.Gson;

/**
 * Created by root on 11/10/16.
 */

public class JadwalBioskop extends Application {

    public static Gson gson;

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.Initialize(this);

    }
}
