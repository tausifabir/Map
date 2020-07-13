package com.example.map.ServiceApi;

import com.example.map.Constants.ConstantValues;
import com.example.map.Network.ProductService;
import com.example.map.Network.RetrofitClient;

public class InvokeProductApi {




    ProductService productService = RetrofitClient
            .getClient(ConstantValues.URL)
            .create(ProductService.class);


}


