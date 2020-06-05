package com.example.plannerify;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayInputStream;

public class ProfilOrg extends AppCompatActivity {
	private  static final int REQUEST_CALL=1;
	 TextView mNumber,sendMail;
	 ImageView mCall ;


	Toolbar toolbarOrg;
	TextView addresseOrg;

	@SuppressLint("SetTextI18n")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil_org);
		addresseOrg=findViewById(R.id.adresseOrg);
		addresseOrg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent iAdresse=new Intent(Intent.ACTION_VIEW);
				iAdresse.setData(Uri.parse("geo:32.3424° , 6.3758°"));
				startActivity(iAdresse);
			}
		});
		mNumber=(TextView) findViewById(R.id.phone_num);
		final String phoneNum=mNumber.getText().toString();
		mCall=(ImageView)findViewById(R.id.call);
		//toolbarOrg=findViewById(R.id.bottom_navigation);

		sendMail=findViewById(R.id.sendMail);
		sendMail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent msg=new Intent(ProfilOrg.this,Chat_OrgClt.class);
				startActivity(msg);

			}
		});

		mNumber.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				makePhoneCall();

			}
		});




	}

	private void makePhoneCall(){
		String phoneNumber=mNumber.getText().toString();
		if (ContextCompat.checkSelfPermission(ProfilOrg.this,
				Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(ProfilOrg.this,
					new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
		} else {
			String dial = "tel:" + phoneNumber;
			startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (requestCode == REQUEST_CALL) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				makePhoneCall();
			} else {
				Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
			}
		}
	}


}
