package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.map.Constants.MyPreferences;
import com.example.map.R;
import com.example.map.Callback.OnAboutSchoolDataView;

public class NoticeActivity2 extends AppCompatActivity implements OnAboutSchoolDataView {

    private RecyclerView schoolAboutRecycler;

    private MyPreferences myPreferences;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice2);

        myPreferences = new MyPreferences(this);



        Toast.makeText(this, ""+myPreferences.getUsername(), Toast.LENGTH_SHORT).show();



    }


    @Override
    public void onAboutSchoolResponseData(Object object) {


    }

    @Override
    public void onAboutSchoolStartLoading() {

    }

    @Override
    public void onAboutSchoolStopLoading() {

    }

    @Override
    public void onAboutSchoolShowMessage(String errMsg) {

    }
}