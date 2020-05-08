package com.example.myplannerify;


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


			Menu menu = new Menu("pastry","300dh","luxurious cake",imageInByte, 1 , "pastry");
			db.insertMenu(menu);

			//start
			//menu
			Bitmap image1 = BitmapFactory.decodeResource(getResources(), R.drawable.a50);
			ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
			image1.compress(Bitmap.CompressFormat.PNG, 100, stream1);
			byte imageInByte1[] = stream1.toByteArray();

			test = this.getIntent().getExtras().getString("type");


			Menu menu1 = new Menu("JANA photography","4000dh","Capturing special event ",imageInByte1, 1 , "photography");
			db.insertMenu(menu1);
			//menu
			Bitmap image2 = BitmapFactory.decodeResource(getResources(), R.drawable.a51);
			ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
			image2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
			byte imageInByte2[] = stream2.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu2 = new Menu("RIVKA SINGER photography","3000dh","Capturing special event ",imageInByte2, 1 , "photography");
			db.insertMenu(menu2);
			//menu
			Bitmap image3 = BitmapFactory.decodeResource(getResources(), R.drawable.a52);
			ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
			image3.compress(Bitmap.CompressFormat.PNG, 100, stream3);
			byte imageInByte3[] = stream3.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu3 = new Menu("STUDIO NAME photography","1500dh","Capturing special event ",imageInByte3, 1 , "photography");
			db.insertMenu(menu3);
			//menu
			Bitmap image4 = BitmapFactory.decodeResource(getResources(), R.drawable.a53);
			ByteArrayOutputStream stream4 = new ByteArrayOutputStream();
			image4.compress(Bitmap.CompressFormat.PNG, 100, stream4);
			byte imageInByte4[] = stream4.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu4 = new Menu("Asian buffets","20000dh","offering special meals ",imageInByte4, 1 , "catering");
			db.insertMenu(menu4);
			//menu
			Bitmap image5 = BitmapFactory.decodeResource(getResources(), R.drawable.a54);
			ByteArrayOutputStream stream5 = new ByteArrayOutputStream();
			image5.compress(Bitmap.CompressFormat.PNG, 100, stream5);
			byte imageInByte5[] = stream5.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu5 = new Menu("American buffet","10000dh","offering special meals ",imageInByte5, 1 , "catering");
			db.insertMenu(menu5);
			//menu
			Bitmap image6 = BitmapFactory.decodeResource(getResources(), R.drawable.a55);
			ByteArrayOutputStream stream6 = new ByteArrayOutputStream();
			image6.compress(Bitmap.CompressFormat.PNG, 100, stream6);
			byte imageInByte6[] = stream6.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu6 = new Menu("brunch buffet","10000dh","offering special meals ",imageInByte6, 1 , "catering");
			db.insertMenu(menu6);
			//menu
			Bitmap image7 = BitmapFactory.decodeResource(getResources(), R.drawable.a56);
			ByteArrayOutputStream stream7 = new ByteArrayOutputStream();
			image7.compress(Bitmap.CompressFormat.PNG, 100, stream7);
			byte imageInByte7[] = stream7.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu7 = new Menu("Emerald jewellery set","50000dh","offering special jewellery ",imageInByte7, 1 , "jewellery");
			db.insertMenu(menu7);
			//menu
			Bitmap image8 = BitmapFactory.decodeResource(getResources(), R.drawable.a57);
			ByteArrayOutputStream stream8 = new ByteArrayOutputStream();
			image8.compress(Bitmap.CompressFormat.PNG, 100, stream8);
			byte imageInByte8[] = stream8.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu8 = new Menu("Van cleef jewellery set","30000dh","offering special jewellery ",imageInByte8, 1 , "jewellery");
			db.insertMenu(menu8);
			//menu
			Bitmap image9 = BitmapFactory.decodeResource(getResources(), R.drawable.a59);
			ByteArrayOutputStream stream9 = new ByteArrayOutputStream();
			image9.compress(Bitmap.CompressFormat.PNG, 100, stream9);
			byte imageInByte9[] = stream9.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu9 = new Menu("Cartier wedding ring","20000dh","offering special jewellery ",imageInByte9, 1 , "jewellery");
			db.insertMenu(menu9);
			//menu
			Bitmap image10 = BitmapFactory.decodeResource(getResources(), R.drawable.a60);
			ByteArrayOutputStream stream10 = new ByteArrayOutputStream();
			image10.compress(Bitmap.CompressFormat.PNG, 100, stream10);
			byte imageInByte10[] = stream10.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu10 = new Menu("dior wedding dress","80000dh","offering special wedding dresses ",imageInByte10, 1 , "dress");
			db.insertMenu(menu10);
			//menu
			Bitmap image11 = BitmapFactory.decodeResource(getResources(), R.drawable.a61);
			ByteArrayOutputStream stream11 = new ByteArrayOutputStream();
			image11.compress(Bitmap.CompressFormat.PNG, 100, stream11);
			byte imageInByte11[] = stream11.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu11 = new Menu("Givenchy wedding dress","70000dh","offering special wedding dresses ",imageInByte11, 1 , "dress");
			db.insertMenu(menu11);
			//menu
			Bitmap image12 = BitmapFactory.decodeResource(getResources(), R.drawable.a62);
			ByteArrayOutputStream stream12 = new ByteArrayOutputStream();
			image12.compress(Bitmap.CompressFormat.PNG, 100, stream12);
			byte imageInByte12[] = stream12.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu12 = new Menu("Versace wedding dress","70000dh","offering special wedding dresses ",imageInByte12, 1 , "dress");
			db.insertMenu(menu12);
			//menu
			Bitmap image13 = BitmapFactory.decodeResource(getResources(), R.drawable.a64);
			ByteArrayOutputStream stream13 = new ByteArrayOutputStream();
			image13.compress(Bitmap.CompressFormat.PNG, 100, stream13);
			byte imageInByte13[] = stream13.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu13 = new Menu("Wedding Beayty Kit","6000dh","offering special wedding beauty experience ",imageInByte13, 1 , "beauty");
			db.insertMenu(menu13);

			//menu
			Bitmap image14 = BitmapFactory.decodeResource(getResources(), R.drawable.a16);
			ByteArrayOutputStream stream14 = new ByteArrayOutputStream();
			image14.compress(Bitmap.CompressFormat.PNG, 100, stream14);
			byte imageInByte14[] = stream14.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu14 = new Menu("Wedding Beayty Kit","900dh","offering special wedding beauty experience ",imageInByte14, 1 , "pastry");
			db.insertMenu(menu14);
			//menu
			Bitmap image15 = BitmapFactory.decodeResource(getResources(), R.drawable.a17);
			ByteArrayOutputStream stream15 = new ByteArrayOutputStream();
			image15.compress(Bitmap.CompressFormat.PNG, 100, stream15);
			byte imageInByte15[] = stream15.toByteArray();

			test = this.getIntent().getExtras().getString("type");

			Menu menu15 = new Menu("Wedding Beayty Kit","1000dh","offering special wedding beauty experience ",imageInByte15, 1 , "pastry");
			db.insertMenu(menu15);


			//finish
			/*


			Menu menu1 = new Menu("ze","najlae","najlae",imageInByte, 2 , "catering");
			db.insertMenu(menu1);


			Menu menu2 = new Menu("ze","najlae","najlae",imageInByte, 3 , "jewellery");
			db.insertMenu(menu2);*/

			Organisateur org = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);
			db.insertOrganisateur(org);

			Organisateur org1 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org1);

			Organisateur org2 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org2);

			Organisateur org3 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org3);

			Organisateur org4 = new Organisateur("ze","najlae","najlae","1","hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org4);

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
