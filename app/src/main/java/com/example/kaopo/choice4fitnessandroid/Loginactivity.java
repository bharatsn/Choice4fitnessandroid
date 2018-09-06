package com.example.kaopo.choice4fitnessandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;

import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class Loginactivity extends AppCompatActivity {
    private ImageView btnlogin,btnsignup;
    private CallbackManager callbackManager;
    private LoginButton FloginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        callbackManager = CallbackManager.Factory.create();

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        setContentView(R.layout.activity_loginactivity);
        btnlogin =  (ImageView)findViewById(R.id.loginbtn);

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));


        FloginButton = (LoginButton) findViewById(R.id.loginfacebook_button);
        FloginButton.setReadPermissions("email");


//        FloginButton.setFragment(this);

        // Callback registration
        FloginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {


            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.d("Datainformation",object.toString());
                                String userId="",name="";
                                // Application code
                                try {
                                    String email = object.getString("email");
                                    userId = object.getString("id");
                                    name = object.getString("name");
                                String birthday = object.getString("birthday"); // 01/31/1980 format


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                                Intent mainIntent = new Intent().setClass(Loginactivity.this,
                                        Userinforactivity.class);
                                mainIntent.putExtra("FID",userId);
                                mainIntent.putExtra("FName",name);
                                startActivity(mainIntent);
                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday,picture");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent().setClass(Loginactivity.this,
                        Userinforactivity.class);

                startActivity(mainIntent);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("dataaa",data+"");
    }

}
