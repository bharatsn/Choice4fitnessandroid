package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import activity.FragmentDrawer;

public class Helpactivity extends Userinforactivity implements FragmentDrawer.FragmentDrawerListener {
    private ImageView btnlogin,btnsignup;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout howto,faqs,news,aboutus,mydiary,myprfilefooter,trackingfooter,musicfooter,reportfooter,communityfooter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_helpactivity);
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
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawerhelp);
        drawerFragment.setUp(R.id.fragment_navigation_drawerhelp, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        howto = (LinearLayout)findViewById(R.id.howtobtn);
        faqs = (LinearLayout)findViewById(R.id.faqslayout);
        news = (LinearLayout)findViewById(R.id.newslayout);
        aboutus = (LinearLayout)findViewById(R.id.aboutuslayout);
        mydiary = (LinearLayout)findViewById(R.id.mydiarylayout);
        myprfilefooter = (LinearLayout)findViewById(R.id.footermyprofile);
        trackingfooter = (LinearLayout)findViewById(R.id.footertracking);
        musicfooter = (LinearLayout)findViewById(R.id.footermusic);
        reportfooter= (LinearLayout)findViewById(R.id.footerreport);
        communityfooter= (LinearLayout)findViewById(R.id.footercommut);
        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent().setClass(Helpactivity.this,Faqsactivity.class);
                mainIntent.putExtra("FID",userId);
                mainIntent.putExtra("FName",name);
                startActivity(mainIntent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mydiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent().setClass(Helpactivity.this,Howtoactivity.class);
                mainIntent.putExtra("FID",userId);
                mainIntent.putExtra("FName",name);
                startActivity(mainIntent);
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
            Intent mainIntent = new Intent().setClass(Helpactivity.this,Userinforactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 1){
            Intent mainIntent = new Intent().setClass(Helpactivity.this,Trackingactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 2){
            Intent mainIntent = new Intent().setClass(Helpactivity.this,NutritionActivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 3){
            Intent mainIntent = new Intent().setClass(Helpactivity.this,MusicActivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 4){
            Intent mainIntent = new Intent().setClass(Helpactivity.this,ReportActivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 5){
            Intent mainIntent = new Intent().setClass(Helpactivity.this,CommuntityActivity.class);
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
