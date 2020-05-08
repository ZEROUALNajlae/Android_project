package com.example.myplannerify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputLayout;

public class AccueilClient extends AppCompatActivity {


    CardView dress , catering , pastry , music , jewellery , beauty , photography ;
    Intent i ;
    RelativeLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        ll = (RelativeLayout) findViewById(R.id.ll);
        dress = (CardView) findViewById(R.id.bankcardId);
        catering = (CardView) findViewById(R.id.catering);
		pastry = (CardView) findViewById(R.id.pastry);
		music = (CardView) findViewById(R.id.music);
		jewellery = (CardView) findViewById(R.id.jewellery);
		beauty = (CardView) findViewById(R.id.beauty);
		photography = (CardView) findViewById(R.id.photography);
		i = new Intent(this,MenuListActivity.class);
        dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	i.putExtra("type" , " 'dress' ");
                startActivity(i);
            }
        });
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
		jewellery.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				i.putExtra("type" , " 'jewellery' ");
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
