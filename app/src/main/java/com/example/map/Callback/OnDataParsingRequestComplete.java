package com.example.map.Callback;

public interface OnDataParsingRequestComplete {

    void onDataParsingSuccess(Object obj);

    void onDataParsingError(String errMsg);
}
