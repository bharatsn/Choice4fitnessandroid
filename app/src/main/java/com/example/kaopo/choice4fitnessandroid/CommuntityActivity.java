package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.ProfileTracker;
import com.facebook.login.widget.ProfilePictureView;

import java.util.Timer;
import java.util.TimerTask;

import activity.FragmentDrawer;

public class CommuntityActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout lnemyprof,lnetracking,lnemusic,lnereport,lnefootercommut;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken;
    private ProfileTracker profileTracker;
    ImageView footerimg;
    ViewPager pager;
    String userId,name;
    ProfilePictureView profilePictureView;
    TextView idtext,Fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communtiyactivity);
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
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawercommu);
        drawerFragment.setUp(R.id.fragment_navigation_drawercommu, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

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
                "Coming soon " + position, Toast.LENGTH_LONG).show();
        if (position == 1) {
            Intent mainIntent = new Intent().setClass(CommuntityActivity.this, Trackingactivity.class);
            mainIntent.putExtra("FID", userId);
            mainIntent.putExtra("FName", name);
            startActivity(mainIntent);

        } else if (position == 0) {
            Intent mainIntent = new Intent().setClass(CommuntityActivity.this, Userinforactivity.class);
            mainIntent.putExtra("FID", userId);
            mainIntent.putExtra("FName", name);
            startActivity(mainIntent);

        } else if (position == 3) {
            Intent mainIntent = new Intent().setClass(CommuntityActivity.this, MusicActivity.class);
            mainIntent.putExtra("FID", userId);
            mainIntent.putExtra("FName", name);
            startActivity(mainIntent);

        } else if (position == 4) {
            Intent mainIntent = new Intent().setClass(CommuntityActivity.this, ReportActivity.class);
            mainIntent.putExtra("FID", userId);
            mainIntent.putExtra("FName", name);
            startActivity(mainIntent);

        } else if (position == 2) {
            Intent mainIntent = new Intent().setClass(CommuntityActivity.this, NutritionActivity.class);
            mainIntent.putExtra("FID", userId);
            mainIntent.putExtra("FName", name);
            startActivity(mainIntent);

        } else if (position == 6) {
            Intent mainIntent = new Intent().setClass(CommuntityActivity.this, Helpactivity.class);
            mainIntent.putExtra("FID", userId);
            mainIntent.putExtra("FName", name);
            startActivity(mainIntent);

        }

    }
}
