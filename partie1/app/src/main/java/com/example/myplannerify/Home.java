package com.example.myplannerify;



import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
//import android.support.v4.view.MenuItemCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import 	androidx.appcompat.widget.Toolbar;
import 	androidx.recyclerview.widget.ItemTouchHelper;
//import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    CardView mycard, mycard2, mycard3, mycard4;
    Intent i,i2,i3,i4 ;
    LinearLayout ll,ll2;

    private BottomNavigationView bottomNavigationView;

    @SuppressLint("WrongViewCast")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main_home);
        //navigation

        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:

                        return true;
                    case R.id.navigation_explore:
                        Intent intentGetStarted = new Intent(Home.this, Explore.class);
                        startActivity(intentGetStarted);
                        return true;
                    case R.id.navigation_chat:
                        return true;
                    case R.id.navigation_profil:
                        Intent intentGetStarted1 = new Intent(Home.this, ProfilClient.class);
                        startActivity(intentGetStarted1);
                        return true;

                }
                return false;
            }
        };

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//end of navigation

        //graduation
        mycard2 = (CardView) findViewById(R.id.bankcardId2);
        i2 = new Intent(this,Graduation.class);
        mycard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i2);
            }
        });

        //engagement
        mycard3 = (CardView) findViewById(R.id.bankcardId3);
        i3 = new Intent(this,Engagement.class);
        mycard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i3);
            }
        });

        //birthday
        mycard4 = (CardView) findViewById(R.id.bankcardId4);
        i4 = new Intent(this,Birthday.class);
        mycard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i4);
            }
        });


        mycard = (CardView) findViewById(R.id.bankcardId);
        i = new Intent(this,AccueilClient.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });



    }
}

