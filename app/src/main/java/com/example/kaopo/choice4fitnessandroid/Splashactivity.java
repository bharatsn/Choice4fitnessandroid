package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splashactivity extends AppCompatActivity {
    private long splashDelay = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                Intent mainIntent = new Intent().setClass(Splashactivity.this,Loginactivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);
    }
}
