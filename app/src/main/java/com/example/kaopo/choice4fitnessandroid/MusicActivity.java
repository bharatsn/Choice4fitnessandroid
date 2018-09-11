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

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.ProfileTracker;
import com.facebook.login.widget.ProfilePictureView;

import java.util.Timer;
import java.util.TimerTask;

import activity.FragmentDrawer;

public class MusicActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout lnemyprof, lnetracking, lnemusic, lnereport, lnefootercommut;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken;
    private ProfileTracker profileTracker;
    ImageView footerimg;
    ViewPager pager;
    String userId, name;
    ProfilePictureView profilePictureView;
    TextView idtext, Fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicactivity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Bundle bundle = getIntent().getExtras();
        userId = bundle.getString("FID");
        name = bundle.getString("FName");
        profilePictureView = (ProfilePictureView) findViewById(R.id.profilepictureslide);
        idtext = (TextView) findViewById(R.id.textValueID);
        Fname = (TextView) findViewById(R.id.textValuename);
        idtext.setText(userId);
        Fname.setText(name);
        profilePictureView.setProfileId(userId);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawermusic);
        drawerFragment.setUp(R.id.fragment_navigation_drawermusic, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        @Override
        public void onDrawerItemSelected (View view,int position){
            if (position == 1) {
                Intent mainIntent = new Intent().setClass(MusicActivity.this, Trackingactivity.class);
                mainIntent.putExtra("FID", userId);
                mainIntent.putExtra("FName", name);
                startActivity(mainIntent);

            } else if (position == 0) {
                Intent mainIntent = new Intent().setClass(MusicActivity.this, Userinforactivity.class);
                mainIntent.putExtra("FID", userId);
                mainIntent.putExtra("FName", name);
                startActivity(mainIntent);

            } else if (position == 2) {
                Intent mainIntent = new Intent().setClass(MusicActivity.this, ReportActivity.class);
                mainIntent.putExtra("FID", userId);
                mainIntent.putExtra("FName", name);
                startActivity(mainIntent);

            } else if (position == 4) {
                Intent mainIntent = new Intent().setClass(MusicActivity.this, ReportActivity.class);
                mainIntent.putExtra("FID", userId);
                mainIntent.putExtra("FName", name);
                startActivity(mainIntent);

            } else if (position == 2) {
                Intent mainIntent = new Intent().setClass(MusicActivity.this, NutritionActivity.class);
                mainIntent.putExtra("FID", userId);
                mainIntent.putExtra("FName", name);
                startActivity(mainIntent);

            } else if (position == 6) {
                Intent mainIntent = new Intent().setClass(MusicActivity.this, Helpactivity.class);
                mainIntent.putExtra("FID", userId);
                mainIntent.putExtra("FName", name);
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
