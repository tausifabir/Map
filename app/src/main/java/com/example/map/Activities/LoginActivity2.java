package com.example.map.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.map.R;
import com.example.map.View.iLoginView;

public class LoginActivity2 extends AppCompatActivity implements iLoginView {

    private EditText et_login_userName,et_login_userPassword;
    private Button btn_login_loginUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn_login_loginUser = findViewById(R.id.btn_login_loginUser);
        et_login_userName = findViewById(R.id.et_login_userName);
        et_login_userPassword = findViewById(R.id.et_login_userPassword);

        final LoginPresenter loginPresenter = new LoginPresenter(this);

        btn_login_loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLoginResult(et_login_userName.getText().toString(),et_login_userPassword.getText().toString());
            }
        });

    }

    @Override
    public void onLoginResult(String Message) {
        Toast.makeText(this, ""+Message, Toast.LENGTH_SHORT).show();

    }
}