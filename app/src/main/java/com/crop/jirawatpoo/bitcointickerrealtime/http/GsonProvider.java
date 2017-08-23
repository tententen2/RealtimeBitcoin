package com.crop.jirawatpoo.bitcointickerrealtime.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by jirawat.poo on 8/22/2017 AD.
 */

public class GsonProvider {

    private static Gson instance;

    public static Gson get() {
        if (instance == null) instance = new GsonBuilder().setPrettyPrinting().create();
        return instance;
    }
}