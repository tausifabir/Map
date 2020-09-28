package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.map.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;
import com.flaviofaria.kenburnsview.TransitionGenerator;

import org.xmlpull.v1.XmlPullParser;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity2 extends AppCompatActivity  {

    private EditText et_login_userName,et_login_userPassword;
    private Button btn_login_loginUser;



    LinearLayout layout10, layout11, layout12;
    LinearLayout layout21, layout22, layout23;

    public ArrayList<String> arrayList = new ArrayList<>();
    public ArrayList<String> checkList = new ArrayList<>();



    private boolean move = true;
    private boolean backPressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2);

        layout10 = findViewById(R.id.centerImage1);
        layout11 = findViewById(R.id.centerImage2);
        layout12 = findViewById(R.id.centerImage3);
        layout21 = findViewById(R.id.centerImage4);
        layout22 = findViewById(R.id.centerImage5);


        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");



        layout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    checkList.add("1");


            }
        });

        layout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    checkList.add("2");
                    swap(checkList);


            }
        });
        layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(move){
                    layout12.setVisibility(View.INVISIBLE);

                }
            }
        });
        layout21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(move){
                    layout21.setVisibility(View.INVISIBLE);

                }
            }
        });
        layout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(move){
                    layout22.setVisibility(View.INVISIBLE);

                }
            }
        });



        /*final KenBurnsView kbv = (KenBurnsView) findViewById(R.id.imageView34);*/


/*
        kbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(move){

                    kbv.pause();
                    move = false;
                }else {
                    kbv.resume();
                    move= true;
                }
            }
        });
*/


/*
        kbv.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

                Toast.makeText(LoginActivity2.this, "Started", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTransitionEnd(Transition transition) {

                Toast.makeText(LoginActivity2.this, "Paused", Toast.LENGTH_SHORT).show();

            }
        });
*/






        //btn_login_loginUser = findViewById(R.id.btn_login_loginUser);
        //et_login_userName = findViewById(R.id.et_login_userName);
        //et_login_userPassword = findViewById(R.id.et_login_userPassword);



    }



    @Override
    public void onBackPressed() {

        if(backPressed){
            super.onBackPressed();


        }



        move = true;
        layout10.setVisibility(View.VISIBLE);
        layout11.setVisibility(View.VISIBLE);
        layout12.setVisibility(View.VISIBLE);
        layout21.setVisibility(View.VISIBLE);
        layout22.setVisibility(View.VISIBLE);

        layout10.setBackgroundResource(R.drawable.ic_profile);
        layout11.setBackgroundResource(R.drawable.ic_user_male2);
        layout12.setBackgroundResource(R.drawable.ic_user_male2);
        layout21.setBackgroundResource(R.drawable.ic_user_male2);
        layout22.setBackgroundResource(R.drawable.ic_user_male2);



        return;
    }

    public void swap(ArrayList value){

        Toast.makeText(this, "Called", Toast.LENGTH_SHORT).show();





        Toast.makeText(this, ""+value, Toast.LENGTH_SHORT).show();


        if(value.get(0).equals("1") && value.get(1).equals("2")){


            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
                layout10.setBackgroundResource(R.drawable.ic_user_male2);
                layout11.setBackgroundResource(R.drawable.ic_profile);

        }

    }
}