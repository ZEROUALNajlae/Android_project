package com.example.plannerify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainClient extends AppCompatActivity {
    Toolbar toolbarClt;
    TextView nom;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
        toolbarClt=findViewById(R.id.cltToolBar);
        setSupportActionBar(toolbarClt);
        nom=findViewById(R.id.nom);
        nom.setText(getIntent().getStringExtra("fbUser"));
        image=findViewById(R.id.image);
        Context context=getApplicationContext();
        Picasso.with(context).load(getIntent().getStringExtra("imageURL")).into(image);

    }
}