package com.example.myplannerify;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import 	androidx.appcompat.widget.Toolbar;
import android.widget.Toast;
import com.example.myplannerify.adapter.MenuAdapter;
import com.example.myplannerify.database_classes.Menu;
import com.example.myplannerify.database_classes.Organisateur;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class MenuListActivity extends AppCompatActivity implements MenuAdapter.OnClickItemListener {


	public static MySQLite db;
	private RecyclerView myrecyclerview;
	private MenuAdapter myAdapter;
	private List<Menu> mesmenus ;
	String test ;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_list);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

			db = new MySQLite(this);

			Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.logo_planerify_me);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			image.compress(Bitmap.CompressFormat.PNG, 100, stream);
			byte imageInByte[] = stream.toByteArray();

			test = this.getIntent().getExtras().getString("type");


			/*Menu menu = new Menu("pastry","najlae","najlae",imageInByte, 1 , "pastry");
			db.insertMenu(menu);

			Menu menu1 = new Menu("ze","najlae","najlae",imageInByte, 2 , "catering");
			db.insertMenu(menu1);


			Menu menu2 = new Menu("ze","najlae","najlae",imageInByte, 3 , "jewellery");
			db.insertMenu(menu2);*/

			Organisateur org = new Organisateur("ze","najlae","najlae",1,"hello","makes","teste",imageInByte, 5);
			db.insertOrganisateur(org);

			Organisateur org1 = new Organisateur("ze","najlae","najlae",1,"hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org1);

			Organisateur org2 = new Organisateur("ze","najlae","najlae",1,"hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org2);

			Organisateur org3 = new Organisateur("ze","najlae","najlae",1,"hello","makes","teste",imageInByte, 5);

			db.insertOrganisateur(org3);

			Organisateur org4 = new Organisateur("ze","najlae","najlae",1,"hello","makes","teste",imageInByte, 5);

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
