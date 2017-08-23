package com.crop.jirawatpoo.bitcointickerrealtime.http.service;

import com.crop.jirawatpoo.bitcointickerrealtime.dao.Pricecheck.pricerespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jirawat.poo on 8/22/2017 AD.
 */

public interface ServicecallPrice {

    @GET("api/trade/")
    Call<pricerespone> getpair(@Query("pairing") String number);
}
