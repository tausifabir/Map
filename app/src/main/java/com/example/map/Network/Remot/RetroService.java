package com.example.map.Network.Remot;


import com.example.map.Model.AboutSchoolModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Babu on 1/5/2018.
 */

public interface RetroService {

    @POST("api/aboutus.php")
    @FormUrlEncoded
    Call<AboutSchoolModel> getAboutSchool(@Field("branch") String branchId);

}
