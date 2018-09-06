package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import activity.FragmentDrawer;

public class Howtoactivity extends Userinforactivity implements FragmentDrawer.FragmentDrawerListener {
    private ImageView btnlogin,btnsignup;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private WebView myBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_howtoactivity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawerhowto);
        drawerFragment.setUp(R.id.fragment_navigation_drawerhowto, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        Bundle bundle = getIntent().getExtras();
        userId = bundle.getString("FID");
        name = bundle.getString("FName");
        profilePictureView = (ProfilePictureView) findViewById(R.id.profilepictureslide);
        idtext = (TextView) findViewById(R.id.textValueID);
        Fname = (TextView) findViewById(R.id.textValuename);
        idtext.setText(userId);
        Fname.setText(name);
        profilePictureView.setProfileId(userId);
        myBrowser = (WebView) findViewById(R.id.webviewhowto);
        WebSettings webSettings = myBrowser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String url = "file:///android_asset/html/howto/mobile/en.html";
        myBrowser.loadUrl(url);
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
            Intent mainIntent = new Intent().setClass(Howtoactivity.this,Userinforactivity.class);
            mainIntent.putExtra("FID",userId);
            mainIntent.putExtra("FName",name);
            startActivity(mainIntent);

        }
        else if(position == 6){
            Intent mainIntent = new Intent().setClass(Howtoactivity.this,Helpactivity.class);
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
