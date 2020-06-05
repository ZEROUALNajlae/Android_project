package com.example.myplannerify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class Birthday extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    CardView dress , catering , pastry , music , jewellery , beauty , photography ;
    Intent i ;
    RelativeLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main_birthday);

        //navigation

        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intentGetStarted = new Intent(Birthday.this, Home.class);
                        startActivity(intentGetStarted);

                        return true;
                    case R.id.navigation_explore:
                        Intent intentGetStarted2 = new Intent(Birthday.this, Explore.class);
                        startActivity(intentGetStarted2);
                        return true;
                    case R.id.navigation_chat:
                        return true;
                    case R.id.navigation_profil:
                        Intent intentGetStarted1 = new Intent(Birthday.this, ProfilClient.class);
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
        catering = (CardView) findViewById(R.id.bankcardId);
        pastry = (CardView) findViewById(R.id.pastry);
        music = (CardView) findViewById(R.id.music);
        beauty = (CardView) findViewById(R.id.beauty);
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
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("type" , " 'music' ");
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


    }



}
