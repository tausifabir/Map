package com.example.map.Presenters;


import com.example.map.ServiceApi.InvokeSchoolAboutApi;
import com.example.map.Callback.OnAboutSchoolDataView;
import com.example.map.Callback.OnDataParsingRequestComplete;

public class SchoolAboutPresenter {
    private OnAboutSchoolDataView onAboutSchoolDataView;

    public SchoolAboutPresenter(OnAboutSchoolDataView onAboutSchoolDataView) {
        this.onAboutSchoolDataView = onAboutSchoolDataView;
    }

    public void getSchoolAbout (String branchId){
        onAboutSchoolDataView.onAboutSchoolStartLoading();
        new InvokeSchoolAboutApi(branchId, new OnDataParsingRequestComplete() {
            @Override
            public void onDataParsingSuccess(Object obj) {
                onAboutSchoolDataView.onAboutSchoolStopLoading();
                onAboutSchoolDataView.onAboutSchoolResponseData(obj);
            }

            @Override
            public void onDataParsingError(String errMsg) {
                onAboutSchoolDataView.onAboutSchoolStopLoading();
                onAboutSchoolDataView.onAboutSchoolShowMessage(errMsg);
            }
        });
    }
}
