package com.example.map.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.map.R;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;

public class ThreadActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button startBtn,stopbtn;
    private TextView showTextTV;
    private DrawerLayout drawer;

    private NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    private ExpandableListView expandableListView;

    private List<String> parentList;
    private List<String> childList;

    private String TAG = "Thread";





    Handler mainHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        startBtn = findViewById(R.id.startbtn);
        stopbtn = findViewById(R.id.stopbtn);
        showTextTV = findViewById(R.id.showTextTV);
        toolbar = findViewById(R.id.toolbar);
        expandableListView = findViewById(R.id.expandable_list);
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.bringToFront();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        actionBarDrawerToggle.syncState();


        showTextTV.setText("Hello");

        getItemList();




    }

    private void getItemList() {

        parentList = new ArrayList<>();

        String [] itemParentList  = getResources().getStringArray(R.array.Parent);
        String [] itemChildList  = getResources().getStringArray(R.array.Child);


        parentList.addAll(Arrays.asList(itemParentList));

        for(int i = 0; i<parentList.size();i++){
            Toast.makeText(this, ""+parentList.get(i), Toast.LENGTH_SHORT).show();
            Log.d("Show", "getItemList: "+parentList.get(i));
        }
    }

    public void statThread(View view) {

        Toast.makeText(ThreadActivity.this, "clicked", Toast.LENGTH_SHORT).show();

       /* ExampleThread exampleThread = new ExampleThread(10);
        exampleThread.start();*/


        ExampleRunnable exampleRunnable = new ExampleRunnable(10);
        new Thread(exampleRunnable).start();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.nav_home) {

            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        }

        return true;
    }


    public class ExampleThread extends Thread{
        int sec;

        public ExampleThread(int sec) {
            this.sec = sec;
        }

        @Override
        public void run() {

            for (int i = 0 ; i < sec ; i++){
                try {
                    Thread.sleep(2000);
                    Log.e(TAG, "statThread: " +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public class ExampleRunnable implements  Runnable{
        int sec;

        public ExampleRunnable(int sec) {
            this.sec = sec;
        }

        @Override
        public void run() {

            for (int i = 0 ; i < sec ; i++){
                try {

                    Handler handler = new Handler(Looper.getMainLooper());
                    
                    if(i==6){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                showTextTV.setText("i = 6");
                            }
                        });
                    }
                    Thread.sleep(2000);
                    Log.e(TAG, "statThread: " +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }
}