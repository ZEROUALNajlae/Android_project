package com.example.plannerify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.location.LocationListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class RegisterOrg extends AppCompatActivity {
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    FusedLocationProviderClient fusedLocationProviderClient;
    EditText username, email, password, phoneNumber, ville, description, rePassword;
    TextView adresse;
    Button btn_register, mButtonChooseImage, mGetLocation;
    private Uri mImageUri;
    TextView mAdresse,mCountry;
    private ImageView mImageView;
    private static final int PICK_IMAGE_REQUEST = 1;
    private DatabaseReference reference;
    Organisateur organisateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_org);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAdresse = findViewById(R.id.adresse);
        mCountry = findViewById(R.id.Country);
        description = findViewById(R.id.description);
        phoneNumber = findViewById(R.id.contact);
        rePassword = findViewById(R.id.rePassword);
        btn_register = findViewById(R.id.register);


        //initialisation
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        mGetLocation = findViewById(R.id.getLocation);
        mGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(RegisterOrg.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(RegisterOrg.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }
            }
        });

        organisateur = new Organisateur();
        reference = FirebaseDatabase.getInstance().getReference().child("Organisateur");
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_username = username.getText().toString();
                String text_email = email.getText().toString();
                String text_password = password.getText().toString();
                String text_rePassword = rePassword.getText().toString();
                String text_phone = phoneNumber.getText().toString();
                String text_description = description.getText().toString();
                String text_adresse = adresse.getText().toString();
                String text_country = mCountry.getText().toString();

                organisateur.setAdresse(text_adresse);
                organisateur.setDescription(text_description);
                organisateur.setPassword(text_password);
                organisateur.setName(text_username);
                organisateur.setEmail(text_email);
                organisateur.setPhoneNumber(text_phone);
                organisateur.setCountry(text_country);
                if(TextUtils.isEmpty(text_username) || TextUtils.isEmpty(text_email) || TextUtils.isEmpty(text_password)){
                    Toast.makeText(RegisterOrg.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else if(text_password.length()<6){
                    Toast.makeText(RegisterOrg.this,"Password must contain at least 6 CHaracters",Toast.LENGTH_SHORT).show();

                }else if(text_password!=text_rePassword){
                    Toast.makeText(RegisterOrg.this,"Passwords are not the same",Toast.LENGTH_SHORT).show();

                }
                else{
                    Log.w("EMAIL*************************", text_email);
                    register(text_username,text_email,text_password);
                }
                reference.push().setValue(organisateur);
                Toast.makeText(RegisterOrg.this, "You have succesfully registerd", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    Geocoder geocoder = new Geocoder(RegisterOrg.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        mCountry.setText(Html.fromHtml("<font color='#808080'><b></b></font>" + addresses.get(0).getCountryName()));
                        mAdresse.setText(Html.fromHtml("<b></b>" + addresses.get(0).getAddressLine(0)));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });



    }



    private void register (final String username, String email, String password){

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterOrg.this, "you are authenticated succefuly....", Toast.LENGTH_LONG).show();
                }
                else {
                    String message= task.getException().getMessage();
                    Toast.makeText(RegisterOrg.this, "Error Occured" + message, Toast.LENGTH_LONG).show();
                }
            }
        });

    }




}