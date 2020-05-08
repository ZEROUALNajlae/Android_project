package com.example.myplannerify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Graduation extends AppCompatActivity {

    CardView  catering , pastry  , beauty , photography ;
    Intent i ;
    RelativeLayout ll;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main_graduation);

        //navigation

        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentGetStarted = new Intent(Graduation.this, Home.class);
                        startActivity(intentGetStarted);

                        return true;
                    case R.id.navigation_explore:
                        Intent intentGetStarted2 = new Intent(Graduation.this, Explore.class);
                        startActivity(intentGetStarted2);
                        return true;
                    case R.id.navigation_chat:
                        return true;
                    case R.id.navigation_profil:
                        Intent intentGetStarted1 = new Intent(Graduation.this, ProfilClient.class);
                        startActivity(intentGetStarted1);
                        return true;

                }
                return false;
            }
        };

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//end of navigation

        ll = (RelativeLayout) findViewById(R.id.ll);
        catering = (CardView) findViewById(R.id.catering);
        pastry = (CardView) findViewById(R.id.pastry);
        beauty = (CardView) findViewById(R.id.beauty);
        photography = (CardView) findViewById(R.id.photography);
        i = new Intent(this,MenuListActivity.class);

        catering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type" , " 'catering' ");
                startActivity(i);
            }
        });
        pastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type" , " 'pastry' ");
                startActivity(i);
            }
        });
        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type" , " 'beauty' ");
                startActivity(i);
            }
        });
        photography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type" , " 'photography' ");
                startActivity(i);
            }
        });

    }

}
