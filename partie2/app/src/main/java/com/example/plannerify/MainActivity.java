package com.example.plannerify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mOrganisator,mClient;
    MediaPlayer Welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Welcome=MediaPlayer.create(MainActivity.this,R.raw.welcome);
        Welcome.start();
        mOrganisator=findViewById(R.id.Organisateur);
        mClient=findViewById(R.id.Client);
        mOrganisator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrg=new Intent(MainActivity.this,LoginOrg.class);
                startActivity(intentOrg);
            }
        });
        mClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentClt=new Intent(MainActivity.this,LoginClient.class);
                startActivity(intentClt);
            }
        });
    }
}