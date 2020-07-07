package com.example.map.Network;

import android.util.Log;


/**
 * Created by Babu on 1/5/2018.
 */

public class ApiUtils {

    //public static final String BASE_URL = "http://demo.101bd.com";

    public static RetroService getLoginDataService(String baseUrl) {
       // String url = "http://"+baseUrl+"/";
        Log.e("baseUrlInService",baseUrl);
        return RetrofitClient.getClient(baseUrl).create(RetroService.class);
    }

    public static AnotherRetroService getAboutUsService() {
        return RetrofitClient.getAnotherClient("http://artificial-soft.com").create(AnotherRetroService.class);
    }
}
