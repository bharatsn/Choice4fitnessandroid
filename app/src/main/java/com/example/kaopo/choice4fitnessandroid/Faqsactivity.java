package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import java.util.Timer;
import java.util.TimerTask;

import activity.FragmentDrawer;

public class Faqsactivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private WebView myBrowser;
    private String userId,name;
    private ProfilePictureView profilePictureView;
    private TextView idtext,Fname,twhatbmi,twhatheart,tknowvital,tknowglucose,tknowcholes;
    private LinearLayout lwhatbmi,lwhayheart,lknowaboutvital,lknowgluscose,lknowchloes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqsactivity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawerfaqs);
        drawerFragment.setUp(R.id.fragment_navigation_drawerfaqs, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        Bundle bundle = getIntent().getExtras();
        userId = bundle.getString("FID");
        name = bundle.getString("FName");
        profilePictureView = (ProfilePictureView) findViewById(R.id.profilepictureslide);
        idtext = (TextView) findViewById(R.id.textValueID);
        Fname = (TextView) findViewById(R.id.textValuename);
        lwhatbmi = (LinearLayout) findViewById(R.id.whatbmiq1);
        lwhayheart = (LinearLayout) findViewById(R.id.whatishearth);
        lknowaboutvital = (LinearLayout) findViewById(R.id.knowabout);
        lknowgluscose = (LinearLayout) findViewById(R.id.knowglucose);
        lknowchloes= (LinearLayout) findViewById(R.id.knowcholes);
        twhatbmi = (TextView) findViewById(R.id.whatbmia);
        twhatheart = (TextView) findViewById(R.id.whatisheartha);
        tknowvital = (TextView) findViewById(R.id.knowabouta);
        tknowglucose = (TextView) findViewById(R.id.knowglucosea);
        tknowcholes = (TextView) findViewById(R.id.knowcholesa);

        idtext.setText(userId);
        Fname.setText(name);
        profilePictureView.setProfileId(userId);


        lwhatbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twhatbmi.setVisibility(View.VISIBLE);
                twhatheart.setVisibility(View.GONE);
                tknowvital.setVisibility(View.GONE);
                tknowglucose.setVisibility(View.GONE);
                tknowcholes.setVisibility(View.GONE);
                lwhatbmi.setBackgroundColor(Color.parseColor("#f97f6c"));
                lwhayheart.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowaboutvital.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowgluscose.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowchloes.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        lwhayheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twhatbmi.setVisibility(View.GONE);
                twhatheart.setVisibility(View.VISIBLE);
                tknowvital.setVisibility(View.GONE);
                tknowglucose.setVisibility(View.GONE);
                tknowcholes.setVisibility(View.GONE);
                lwhatbmi.setBackgroundColor(Color.parseColor("#ffffff"));
                lwhayheart.setBackgroundColor(Color.parseColor("#f97f6c"));
                lknowaboutvital.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowgluscose.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowchloes.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        lknowaboutvital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twhatbmi.setVisibility(View.GONE);
                twhatheart.setVisibility(View.GONE);
                tknowvital.setVisibility(View.VISIBLE);
                tknowglucose.setVisibility(View.GONE);
                tknowcholes.setVisibility(View.GONE);
                lwhatbmi.setBackgroundColor(Color.parseColor("#ffffff"));
                lwhayheart.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowaboutvital.setBackgroundColor(Color.parseColor("#f97f6c"));
                lknowgluscose.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowchloes.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        lknowgluscose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twhatbmi.setVisibility(View.GONE);
                twhatheart.setVisibility(View.GONE);
                tknowvital.setVisibility(View.GONE);
                tknowglucose.setVisibility(View.VISIBLE);
                tknowcholes.setVisibility(View.GONE);
                lwhatbmi.setBackgroundColor(Color.parseColor("#ffffff"));
                lwhayheart.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowaboutvital.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowgluscose.setBackgroundColor(Color.parseColor("#f97f6c"));
                lknowchloes.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        lknowchloes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twhatbmi.setVisibility(View.GONE);
                twhatheart.setVisibility(View.GONE);
                tknowvital.setVisibility(View.GONE);
                tknowglucose.setVisibility(View.GONE);
                tknowcholes.setVisibility(View.VISIBLE);
                lwhatbmi.setBackgroundColor(Color.parseColor("#ffffff"));
                lwhayheart.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowaboutvital.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowgluscose.setBackgroundColor(Color.parseColor("#ffffff"));
                lknowchloes.setBackgroundColor(Color.parseColor("#f97f6c"));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onDrawerItemSelected(View view, int position) {
        if(position == 0){
            Intent mainIntent = new Intent().setClass(Faqsactivity.this,Userinforactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 1){
            Intent mainIntent = new Intent().setClass(Faqsactivity.this,Trackingactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 6){
            Intent mainIntent = new Intent().setClass(Faqsactivity.this,Helpactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
