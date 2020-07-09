package com.example.map.Network.Remot;


import com.example.map.Model.AboutUsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Babu on 2/16/2018.
 */

public interface AnotherRetroService {
    @POST("/api/about.php")
    @FormUrlEncoded
    Call<AboutUsModel> aboutUs(@Field("category") String category);
}
