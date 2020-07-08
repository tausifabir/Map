package com.example.map.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class iUser implements User {

    public String email;
    public String password;

    public iUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidData() {

        return !TextUtils.isEmpty(getEmail()) ;
    }
}
