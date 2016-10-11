package com.example.root.jadwalbioskop.API;

import com.example.root.jadwalbioskop.Dagger.Injector;

/**
 * Created by root on 11/10/16.
 */

public class RequestToKota {
    protected ApiClient apiClient;
    public RequestToKota() {
        apiClient.getApiInterface().kotaList();

    }
}
