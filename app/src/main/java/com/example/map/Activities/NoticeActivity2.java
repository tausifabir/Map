package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.map.Adapter.SchoolAboutAdapter;
import com.example.map.Model.AboutSchoolListModel;
import com.example.map.R;
import com.example.map.Callback.OnAboutSchoolDataView;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity2 extends AppCompatActivity implements OnAboutSchoolDataView {

    private List<AboutSchoolListModel> aboutSchoolList = new ArrayList<>();
    private SchoolAboutAdapter schoolAboutAdapter;
    private RecyclerView schoolAboutRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice2);

        schoolAboutRecycler = findViewById(R.id.school_abt_recycler);
    }

    @Override
    public void onAboutSchoolResponseData(Object object) {

        aboutSchoolList = (List<AboutSchoolListModel>) object;
        Log.d("about", aboutSchoolList.size() + "");
        schoolAboutAdapter = new SchoolAboutAdapter(getApplicationContext(), aboutSchoolList);
        schoolAboutRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        schoolAboutRecycler.setAdapter(schoolAboutAdapter);
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