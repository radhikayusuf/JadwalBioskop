package com.example.root.jadwalbioskop.Dagger;

import com.example.root.jadwalbioskop.API.ApiClient;
import com.example.root.jadwalbioskop.Main.ViewModel.MainActivityVM;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by root on 11/10/16.
 */

@Singleton
@Component(modules ={
        AppModule.class,
        NetModule.class
        })

public interface DiComponent {
        ApiClient apiClient();

        void inject(MainActivityVM viewModel);

}
