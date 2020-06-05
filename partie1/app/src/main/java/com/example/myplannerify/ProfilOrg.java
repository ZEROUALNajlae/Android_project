package com.example.myplannerify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.myplannerify.database_classes.*;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

public class ProfilOrg extends AppCompatActivity {
	private  static final int REQUEST_CALL=1;
	private TextView mNumber, nom , email , description, adresse , commentaire , statut;
	private ImageView mCall , image;
	private ImageButton ilike;
	private Organisateur org;
	int id ;
	int i;
	int k = 0 ;


	@SuppressLint("SetTextI18n")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil_org);
		mNumber=(TextView) findViewById(R.id.phone);
		mCall=(ImageView)findViewById(R.id.call);
		nom = (TextView) findViewById(R.id.nom);
		email = (TextView) findViewById(R.id.email);
		description = (TextView) findViewById(R.id.description);
		adresse = (TextView) findViewById(R.id.adresse);
		image = (ImageView) findViewById(R.id.image);
		commentaire = (TextView) findViewById(R.id.commentaire);
		ilike = (ImageButton) findViewById(R.id.ilike_button);
		statut = (TextView) findViewById(R.id.statut);


		mCall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				makePhoneCall();

			}
		});


		id = this.getIntent().getExtras().getInt("id");
		org = MenuListActivity.db.getOrganisateur(id);
		nom.setText(org.getNom_organisateur());
		email.setText(org.getEmail_organisateur());
		mNumber.setText(org.getContact_organisateur());
		description.setText(org.getDescription_organisateur());
		adresse.setText(org.getAdresse_organisateur());
		ByteArrayInputStream imageStream = new ByteArrayInputStream(org.getImage_organisateur());
		Bitmap theImage = BitmapFactory.decodeStream(imageStream);
		this.image.setImageBitmap(theImage);



		i = MenuListActivity.db.getLikes_Organisateur(id);
		commentaire.setText(Integer.toString(i));

		ilike.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				//Toast.makeText(getApplicationContext(), Integer.toString( org.getId_organisateur()) ,  Toast.LENGTH_SHORT).show();
				k ++;

				if((k % 2) != 0){
					MenuListActivity.db.addLike(org);
					i = MenuListActivity.db.getLikes_Organisateur(id);
					//Toast.makeText(this, Integer.toString( org.getId_organisateur()) ,  Toast.LENGTH_SHORT).show();
					commentaire.setText(Integer.toString(i));
					statut.setText("Vous aimez cette organisateur");
					Toast.makeText(getApplicationContext(), "J'aime ", Toast.LENGTH_SHORT).show();
				}
				if((k % 2) == 0){
					MenuListActivity.db.deleteLike(org);
					i = MenuListActivity.db.getLikes_Organisateur(id);
					//Toast.makeText(this, Integer.toString( org.getId_organisateur()) ,  Toast.LENGTH_SHORT).show();
					commentaire.setText(Integer.toString(i));
					statut.setText("");
					Toast.makeText(getApplicationContext(), "Je n'aime plus ", Toast.LENGTH_SHORT).show();
				}

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
