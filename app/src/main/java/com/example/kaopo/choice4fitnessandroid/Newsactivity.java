package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Newsactivity extends AppCompatActivity {
    private long splashDelay = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqsactivity);
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                Intent mainIntent = new Intent().setClass(Newsactivity.this,Loginactivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);
    }
}
