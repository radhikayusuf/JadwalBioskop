package com.example.root.jadwalbioskop.Dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Varokah on 10/11/2016.
 */

@Module
public class AppModule {
    Application mApplication;
    public AppModule(Application application){
        mApplication = application;
    }

    @Singleton
    @Provides
    Application provideApplication(){
        return mApplication;
    }
}
