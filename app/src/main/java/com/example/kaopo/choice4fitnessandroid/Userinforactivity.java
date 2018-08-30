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
import android.widget.ListView;
import android.widget.Toast;

import activity.FragmentDrawer;
import activity.Mypageradapter;

public class Userinforactivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout lnemyprof,lnetracking,lnemusic,lnereport,lnefootercommut;
    ImageView footerimg;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

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

        if(position == 6){
            Intent mainIntent = new Intent().setClass(Userinforactivity.this,Helpactivity.class);
            startActivity(mainIntent);

        }
    }
}