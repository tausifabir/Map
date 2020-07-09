package com.example.map.ServiceApi;



import com.example.map.Constants.ConstantValues;
import com.example.map.Callback.OnDataParsingRequestComplete;
import com.example.map.Network.ApiUtil.ApiUtils;
import com.example.map.Model.AboutSchoolModel;
import com.example.map.Network.Remot.RetroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvokeSchoolAboutApi {
    private OnDataParsingRequestComplete requestComplete;

    public InvokeSchoolAboutApi(String branchId, final OnDataParsingRequestComplete requestComplete) {
        this.requestComplete = requestComplete;

        RetroService retroService = ApiUtils.getLoginDataService(ConstantValues.URL);
        retroService.getAboutSchool(branchId).enqueue(new Callback<AboutSchoolModel>() {
            @Override
            public void onResponse(Call<AboutSchoolModel> call, Response<AboutSchoolModel> response) {
                if (response.isSuccessful()){
                    if (response.body().getError()==0){
                        requestComplete.onDataParsingSuccess(response.body().getSchoolAbout());
                    }
                    else {
                        requestComplete.onDataParsingError(response.body().getErrorReport());
                    }
                }
                else {
                    requestComplete.onDataParsingError("Something went wrong one!");
                }
            }

            @Override
            public void onFailure(Call<AboutSchoolModel> call, Throwable t) {
                requestComplete.onDataParsingError("Something went wrong!"+t.getMessage());
            }
        });
    }
}
