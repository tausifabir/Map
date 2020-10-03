package com.example.map.Constants;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class MyPreferences {

     private static MyPreferences myPreferences;
     private static SharedPreferences sharedPreferences;
     private static SharedPreferences.Editor editor;
     private Context context;


     private static String KEY_NAME = "username";
     private static String KEY_PASS = "password";


    public MyPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("my_shared",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public static MyPreferences getPreferences(Context context){
        if(myPreferences == null){
            myPreferences = new MyPreferences(context);
        }
        return myPreferences;
    }

    public void setUsername(String name){
        editor.putString(name,KEY_NAME);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString(KEY_NAME,"null");
    }

    public void setPass(String pass){
        editor.putString(pass,KEY_PASS);
        editor.commit();
    }

    public String getPass(){
        return  sharedPreferences.getString(KEY_PASS,"Password NoT Found");

    }







}
