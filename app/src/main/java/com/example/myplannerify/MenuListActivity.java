package com.example.myplannerify;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import 	androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.Toast;
import com.example.myplannerify.adapter.MenuAdapter;
import com.example.myplannerify.database_classes.Menu;
import com.example.myplannerify.database_classes.Organisateur;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class MenuListActivity extends AppCompatActivity implements MenuAdapter.OnClickItemListener {

	private BottomNavigationView bottomNavigationView;
	public static MySQLite db;
	private RecyclerView myrecyclerview;
	private MenuAdapter myAdapter;
	private List<Menu> mesmenus ;
	String test ;


        @SuppressLint("WrongThread")
		@Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_list);

			//navigation

			BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
					= new BottomNavigationView.OnNavigationItemSelectedListener() {

				@Override
				public boolean onNavigationItemSelected(@NonNull MenuItem item) {
					Fragment fragment;
					switch (item.getItemId()) {
						case R.id.navigation_home:
							Intent intentGetStarted = new Intent(MenuListActivity.this, Home.class);
							startActivity(intentGetStarted);

							return true;
						case R.id.navigation_explore:
							Intent intentGetStarted2 = new Intent(MenuListActivity.this, Explore.class);
							startActivity(intentGetStarted2);
							return true;
						case R.id.navigation_chat:
							return true;
						case R.id.navigation_profil:
							Intent intentGetStarted1 = new Intent(MenuListActivity.this, ProfilClient.class);
							startActivity(intentGetStarted1);
							return true;

					}
					return false;
				}
			};

			bottomNavigationView = findViewById(R.id.navigation);
			bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//end of navigation

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

			db = new MySQLite(this);

			Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.cake);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			image.compress(Bitmap.CompressFormat.PNG, 100, stream);
			byte imageInByte[] = stream.toByteArray();

			test = this.getIntent().getExtras().getString("type");




			/*

			Menu menu1 = new Menu("ze","najlae","najlae",imageInByte, 2 , "catering");
			db.insertMenu(menu1);


			Menu menu2 = new Menu("ze","najlae","najlae",imageInByte, 3 , "jewellery");
			db.insertMenu(menu2);*/

			//Organisateur org = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);
			//db.insertOrganisateur(org);

			//Organisateur org1 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			//db.insertOrganisateur(org1);

			Organisateur org2 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			//db.insertOrganisateur(org2);

			Organisateur org3 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			//db.insertOrganisateur(org3);

			Organisateur org4 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			//db.insertOrganisateur(org4);

			mesmenus = db.getMenus(test);
			myrecyclerview = (RecyclerView) findViewById(R.id.recyclerViewBeneficiary);
			myAdapter = new MenuAdapter(mesmenus , this);
			myrecyclerview.setAdapter(myAdapter);
			myrecyclerview.setLayoutManager(new LinearLayoutManager(this));


        }


	@Override
	public void OnClickItem(int position) {
		Intent Activity = new Intent(MenuListActivity.this, ProfilOrg.class);
		Activity.putExtra("id" , mesmenus.get(position).getId_organisateur());
		//Toast.makeText(this, Integer.toString(mesmenus.get(position).getId_organisateur() ), Toast.LENGTH_SHORT).show();
		startActivity(Activity);

	}
}
