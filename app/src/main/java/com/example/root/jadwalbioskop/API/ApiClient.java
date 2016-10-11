package com.example.root.jadwalbioskop.API;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Varokah on 10/11/2016.
 */

public class ApiClient {
    ApiInterface apiInterface;

    public ApiClient(String baseUrl){
        OkHttpClient client =new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new MyInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(baseUrl)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    private class MyInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response res = chain.proceed(request);
            Log.d("Response2 : ", res.body().toString());
            return res;
        }
    }
    public ApiInterface getApiInterface() {return apiInterface;}
}
