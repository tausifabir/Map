package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.map.R;


public class LoginActivity2 extends AppCompatActivity {

    private EditText et_login_userName,et_login_userPassword;
    private Button btn_login_loginUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn_login_loginUser = findViewById(R.id.btn_login_loginUser);
        et_login_userName = findViewById(R.id.et_login_userName);
        et_login_userPassword = findViewById(R.id.et_login_userPassword);



    }


}