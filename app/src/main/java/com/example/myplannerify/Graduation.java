package com.example.myplannerify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Graduation extends AppCompatActivity {

    CardView  catering , pastry  , beauty , photography ;
    Intent i ;
    RelativeLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main_graduation);
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
