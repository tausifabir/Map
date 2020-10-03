package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.map.Constants.MyPreferences;
import com.example.map.R;

import java.util.ArrayList;


public class LoginActivity2 extends AppCompatActivity  {

    private EditText et_login_userName,et_login_userPassword;
    private Button btn_login_loginUser;

    ArrayList<LinearLayout> checkList = new ArrayList<>();

    LinearLayout layout10, layout11, layout12;
    LinearLayout layout21, layout22, layout23;


    private MyPreferences myPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        layout10 = findViewById(R.id.centerImage1);
        layout11 = findViewById(R.id.centerImage2);
        layout12 = findViewById(R.id.centerImage3);
        layout21 = findViewById(R.id.centerImage4);
        layout22 = findViewById(R.id.centerImage5);


        myPreferences = MyPreferences.getPreferences(this);







      /*  layout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    checkList.add(layout10);
                    getSwapLayout(checkList);
                    Toast.makeText(LoginActivity2.this, "clicked", Toast.LENGTH_SHORT).show();


            }
        });*/
/*
        layout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    checkList.add(layout11);
                    getSwapLayout(checkList);
                    Toast.makeText(LoginActivity2.this, "clicked", Toast.LENGTH_SHORT).show();



            }
        });*/

/*
        layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    checkList.add(layout12);
                    getSwapLayout(checkList);
                    Toast.makeText(LoginActivity2.this, "Touched", Toast.LENGTH_SHORT).show();
            }
        });*/


       /* layout21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                userPreference.swap(1);
                getSwapLayout(checkList);
                Toast.makeText(LoginActivity2.this, "Touched", Toast.LENGTH_SHORT).show();
            }
        });*/


      /*  layout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkList.add(layout22);
                getSwapLayout(checkList);
                Toast.makeText(LoginActivity2.this, "Touched", Toast.LENGTH_SHORT).show();
            }
        });
*/


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

        btn_login_loginUser = findViewById(R.id.btn_login_loginUser);
        et_login_userName = findViewById(R.id.et_login_userName);
        et_login_userPassword = findViewById(R.id.et_login_userPassword);

        btn_login_loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity2.this,NoticeActivity2.class);
                startActivity(intent);

                String name = et_login_userName.getText().toString();
                myPreferences.setUsername(name);


            }
        });







    }



/*
    private void getSwapLayout(ArrayList<LinearLayout> checkList1) {

        ArrayList<LinearLayout> checkingList = new ArrayList<>();
        checkingList = checkList;


        if(checkingList.get(1).equals()) {

            LinearLayout layout = checkingList.get(0);
            layout10




            layout11.setBackgroundResource(R.drawable.ic_profile);
            checkingList.removeAll(checkList);

        }else if(checkingList.get(0).equals(1) && checkingList.get(1).equals(3)){




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
*/



    @Override
    public void onBackPressed() {

            super.onBackPressed();


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


}