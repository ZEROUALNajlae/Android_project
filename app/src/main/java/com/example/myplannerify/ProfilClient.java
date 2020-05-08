package com.example.myplannerify;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ProfilClient extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_client);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //navigation

        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentGetStarted = new Intent(ProfilClient.this, Home.class);
                        startActivity(intentGetStarted);

                        return true;
                    case R.id.navigation_explore:
                        Intent intentGetStarted1 = new Intent(ProfilClient.this, Explore.class);
                        startActivity(intentGetStarted1);
                        return true;
                    case R.id.navigation_chat:
                        return true;
                    case R.id.navigation_profil:

                        return true;

                }
                return false;
            }
        };

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//end of navigation
    }
}
