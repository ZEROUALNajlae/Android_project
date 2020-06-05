package com.example.myplannerify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myplannerify.database_classes.Organisateur;

public class profiOrganisateur extends AppCompatActivity {
    private Organisateur organisateur;
    private TextView name, email , adresse, back, btnsub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profi_organisateur);
        btnsub = (TextView) findViewById(R.id.back);
        btnsub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(profiOrganisateur.this, AddMenu.class);
                startActivity(i);            }
        });


        organisateur = MainActivity.db.getOrganisteur(MainActivity.email);

        name = findViewById(R.id.name);
        //mobile = findViewById(R.id.mobile_client);
        email = findViewById(R.id.email);
        adresse = findViewById(R.id.adresse);
        back = findViewById(R.id.back);
        name.setText(organisateur.getNom_organisateur() );
        email.setText(organisateur.getEmail_organisateur());

        adresse.setText(organisateur.getAdresse_organisateur());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profiOrganisateur.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}