package com.example.map.Callback;

public interface OnAboutSchoolDataView {
    void onAboutSchoolResponseData(Object object);

    void onAboutSchoolStartLoading();

    void onAboutSchoolStopLoading();

    void onAboutSchoolShowMessage(String errMsg);
}
