package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.widget.ProfilePictureView;

import activity.FragmentDrawer;
import activity.Mypageradapter;

public class Userinforactivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout lnemyprof,lnetracking,lnemusic,lnereport,lnefootercommut;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken  accessToken;
    private ProfileTracker profileTracker;
    ImageView footerimg;
    ViewPager pager;
    String userId,name;
    ProfilePictureView profilePictureView;
    TextView idtext,Fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        callbackManager = CallbackManager.Factory.create();


        Bundle bundle = getIntent().getExtras();
        userId = bundle.getString("FID");
        name = bundle.getString("FName");
        profilePictureView = (ProfilePictureView) findViewById(R.id.profilepictureslide);
        idtext = (TextView) findViewById(R.id.textValueID);
        Fname = (TextView) findViewById(R.id.textValuename);
        idtext.setText(userId);
        Fname.setText(name);
        profilePictureView.setProfileId(userId);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        lnemyprof = (LinearLayout) findViewById(R.id.footermyprofile);
        lnetracking = (LinearLayout) findViewById(R.id.footertracking);
        lnemusic = (LinearLayout) findViewById(R.id.footermusic);
        lnereport = (LinearLayout) findViewById(R.id.footerreport);
        lnefootercommut = (LinearLayout) findViewById(R.id.footercommut);
        footerimg = (ImageView)findViewById(R.id.footerimg);
        pager = (ViewPager) findViewById(R.id.pagers);
        setSupportActionBar(mToolbar);

        Mypageradapter adapter = new Mypageradapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("position",""+position);
                if (position == 0) {
                    footerimg.setImageResource(R.drawable.medlek1);
                }
                else if (position == 1) {
                    footerimg.setImageResource(R.drawable.medlek2);
                }

                else if (position == 2) {
                    footerimg.setImageResource(R.drawable.medlek3);
                }



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        lnefootercommut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Coming soon", Toast.LENGTH_LONG).show();
            }
        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
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

    @Override
    public void onDrawerItemSelected(View view, int position) {
        Toast.makeText(getApplicationContext(),
                "Coming soon "+position, Toast.LENGTH_LONG).show();
        if(position == 1){
            Intent mainIntent = new Intent().setClass(Userinforactivity.this,Trackingactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
       else if(position == 6){
            Intent mainIntent = new Intent().setClass(Userinforactivity.this,Helpactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
    }
}