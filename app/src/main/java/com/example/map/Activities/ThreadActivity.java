package com.example.map.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.map.R;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.concurrent.BlockingDeque;

public class ThreadActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button startBtn,stopbtn;
    private TextView showTextTV;
    private DrawerLayout drawer;

    private NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

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
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        showTextTV.setText("Hello");

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
        return false;
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
}