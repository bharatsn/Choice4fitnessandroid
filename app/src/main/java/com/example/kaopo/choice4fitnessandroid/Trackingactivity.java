package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
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
import activity.Mypageradapter;
import activity.Mypagertrackingadapter;

public class Trackingactivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout howto,faqs,news,aboutus,mydiary,myprfilefooter,trackingfooter,musicfooter,reportfooter,communityfooter;
    ImageView footerimg;
    ViewPager pager;
    String userId,name;
    ProfilePictureView profilePictureView;
    TextView idtext,Fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackingactivity);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Bundle bundle = getIntent().getExtras();
        userId = bundle.getString("FID");
        name = bundle.getString("FName");
        profilePictureView = (ProfilePictureView) findViewById(R.id.profilepictureslide);
        idtext = (TextView) findViewById(R.id.textValueID);
        Fname = (TextView) findViewById(R.id.textValuename);
        pager = (ViewPager) findViewById(R.id.pagerstracking);
        idtext.setText(userId);
        Fname.setText(name);
        profilePictureView.setProfileId(userId);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawertracking);
        drawerFragment.setUp(R.id.fragment_navigation_drawerhelp, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        footerimg = (ImageView)findViewById(R.id.footerimgtracking);
        myprfilefooter = (LinearLayout)findViewById(R.id.footermyprofile);
        trackingfooter = (LinearLayout)findViewById(R.id.footertracking);
        musicfooter = (LinearLayout)findViewById(R.id.footermusic);
        reportfooter= (LinearLayout)findViewById(R.id.footerreport);
        communityfooter= (LinearLayout)findViewById(R.id.footercommut);

        Mypagertrackingadapter adapter = new Mypagertrackingadapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
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
            Intent mainIntent = new Intent().setClass(Trackingactivity.this,Userinforactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 6){
            Intent mainIntent = new Intent().setClass(Trackingactivity.this,Helpactivity.class);
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