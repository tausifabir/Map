package com.example.map.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *
 * Created by Babu on 1/5/2018.
 *
 */

public class RetrofitClient {

    public static Retrofit getClient(String baseUrl){

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
