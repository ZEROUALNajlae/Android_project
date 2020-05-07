package com.example.myplannerify;



import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
//import android.support.v4.view.MenuItemCompat;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import 	androidx.appcompat.widget.Toolbar;
import 	androidx.recyclerview.widget.ItemTouchHelper;
//import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    CardView mycard ;
    Intent i ;
    LinearLayout ll;
    @SuppressLint("WrongViewCast")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ll = (LinearLayout) findViewById(R.id.ll);
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

