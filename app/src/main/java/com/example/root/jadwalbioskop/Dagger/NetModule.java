package com.example.root.jadwalbioskop.Dagger;

import com.example.root.jadwalbioskop.API.ApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Varokah on 10/11/2016.
 */

@Module
public class NetModule {
    @Singleton
    @Provides
    ApiClient provideApiClient() {
        return new ApiClient("http://ibacor.com/");
    }
}
