package com.example.root.jadwalbioskop.Dagger;

import com.example.root.jadwalbioskop.API.ApiClient;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.Main.KotaRequestImpl;
import com.example.root.jadwalbioskop.MovieList.MovieRequest;
import com.example.root.jadwalbioskop.MovieList.MovieRequestImpl;

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
        return new ApiClient("http://ibacor.com");
    }

    @Singleton
    @Provides
    KotaRequest provideKotaReq(){ return new KotaRequestImpl(); }


    @Singleton
    @Provides
    MovieRequest provideMovieReq(){ return new MovieRequestImpl(); }

}
