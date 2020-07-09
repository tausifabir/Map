package com.example.map.Network;

import com.example.map.Model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {


    @GET("api/home_page.php")
    Call<ProductResponse> getRecordResponse();
}
