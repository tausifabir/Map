package com.example.map.Network;


import com.example.map.Model.AboutSchoolModel;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Babu on 1/5/2018.
 */

public interface RetroService {

    @POST("api/aboutus.php")
    @FormUrlEncoded
    Call<AboutSchoolModel> getAboutSchool(@Field("branch") String branchId);

}
