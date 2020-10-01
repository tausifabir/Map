package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
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


    ArrayList<Integer> checkList = new ArrayList<>();

    LinearLayout layout10, layout11, layout12;
    LinearLayout layout21, layout22, layout23;






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



        layout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    swap(1);
                    Toast.makeText(LoginActivity2.this, "clicked", Toast.LENGTH_SHORT).show();


            }
        });

        layout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    swap(2);
                    Toast.makeText(LoginActivity2.this, "clicked", Toast.LENGTH_SHORT).show();



            }
        });
        layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    swap(3);
                    Toast.makeText(LoginActivity2.this, "Touched", Toast.LENGTH_SHORT).show();
            }
        });
        layout21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swap(4);
                Toast.makeText(LoginActivity2.this, "Touched", Toast.LENGTH_SHORT).show();
            }
        });
        layout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swap(5);
                Toast.makeText(LoginActivity2.this, "Touched", Toast.LENGTH_SHORT).show();
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
        layout12.setBackgroundResource(R.drawable.wallet);
        layout21.setBackgroundResource(R.drawable.bank);
        layout22.setBackgroundResource(R.drawable.lock);

        checkList.removeAll(checkList);



    }

    public void swap(int value){

        checkList.add(value);

        if(checkList.size()>1){
            swap1(checkList);
        }

    }

    private void swap1(ArrayList<Integer> checkList1) {

        ArrayList<Integer> checkingList = new ArrayList<>();

        checkingList = checkList;


        if(checkingList.get(0).equals(1) && checkingList.get(1).equals(2)) {

            layout10.setBackgroundResource(R.drawable.ic_user_male2);
            layout11.setBackgroundResource(R.drawable.ic_profile);
            checkingList.removeAll(checkList);

        }else if(checkingList.get(0).equals(1) && checkingList.get(1).equals(3)){


            layout10.setBackgroundResource(R.drawable.wallet);
            layout12.setBackgroundResource(R.drawable.ic_profile);
            checkingList.removeAll(checkList);

        }else if(checkingList.get(0).equals(1) && checkingList.get(1).equals(4)) {


            layout10.setBackgroundResource(R.drawable.bank);
            layout21.setBackgroundResource(R.drawable.ic_profile);
            checkingList.removeAll(checkList);

        }else if(checkingList.get(0).equals(1) && checkingList.get(1).equals(5)){


            layout10.setBackgroundResource(R.drawable.lock);
            layout22.setBackgroundResource(R.drawable.ic_profile);
            checkingList.removeAll(checkList);

        }


    }
}