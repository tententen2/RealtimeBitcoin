package com.crop.jirawatpoo.bitcointickerrealtime.http;

import android.support.annotation.NonNull;

import com.crop.jirawatpoo.bitcointickerrealtime.http.service.ServicecallPrice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jirawat.poo on 8/22/2017 AD.
 */

public class HttpProvider  {

    private static HttpProvider instance;


    public static HttpProvider get(){
        if(instance == null) instance = new HttpProvider();
        return instance;
    }

    public ServicecallPrice servicecallPrice(){
        return retrofit(ServiceUrl.BaseUrl).create(ServicecallPrice.class);
    }


    private Retrofit retrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonProvider.get()))
                .client(httpClient())
                .build();
    }

    private OkHttpClient httpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(cacheInterceptor())
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .cache(new Cache(new File("location"), 1024 * 1024 * 10))
                .build();
    }

    @NonNull
    private Interceptor cacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                String cacheControl = originalResponse.header("Cache-Control");
                if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                        cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")) {
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, max-age=" + 180)
                            .build();
                } else {
                    return originalResponse;
                }
            }
        };
    }
}
