package com.example.root.jadwalbioskop.API;

import com.example.root.jadwalbioskop.Dagger.Injector;

/**
 * Created by Varokah on 10/11/2016.
 */

public class BaseRequest {
    protected ApiClient apiClient;
    public BaseRequest() {
        apiClient = Injector.component.apiClient();
    }
}
