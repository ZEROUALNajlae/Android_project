package com.example.plannerify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;

public class LoginClient extends AppCompatActivity {
    EditText mEmail,mPassword;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login_client);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                if (profile != null){

                    String fbUser= profile.getName();
                    String imageURL= "https://graph.facebook.com/" + loginResult.getAccessToken().getUserId() + "/picture?return_ssl_ressources=1";
                    Intent intFb=new Intent(LoginClient.this,MainClient.class);
                    intFb.putExtra("fbUser",fbUser);
                    intFb.putExtra("imageURL",imageURL);
                    startActivity(intFb);
                }

            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginClient.this,"error,try again!",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(LoginClient.this,"error ,try again!",Toast.LENGTH_LONG).show();

            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode , resultCode , data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}