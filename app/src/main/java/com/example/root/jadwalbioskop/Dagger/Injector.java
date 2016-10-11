package com.example.root.jadwalbioskop.Dagger;

import android.app.Application;

/**
 * Created by Varokah on 10/11/2016.
 */

public class Injector {
    public static DiComponent component;

    public static DiComponent Initialize(Application application){
        component = DaggerDiComponent.builder()
                .appModule(new AppModule(application))
                .netModule(new NetModule())
                .build();
        return component;
    }
}
