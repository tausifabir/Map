package com.example.map.Constants;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.map.Activities.MainActivity;
import com.example.map.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class UserPreference {

     private SharedPreferences sharedPreferences;
     private SharedPreferences.Editor editor;

     public ArrayList<Integer> userList = new ArrayList();


    public UserPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("swaap",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }



    public void swap(int value){

        ArrayList<Integer> checkList = new ArrayList<>();

        checkList.add(value);
        editor.putInt("key",value);

    }

    public  int getSwap(){

        return sharedPreferences.getInt("key",1);
    }



}
