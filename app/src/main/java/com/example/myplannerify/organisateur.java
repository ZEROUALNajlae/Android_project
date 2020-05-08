package com.example.myplannerify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myplannerify.database_classes.Organisateur;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class organisateur extends AppCompatActivity {
    MySQLite db;
    EditText e1 , e2 , e4, e5, e6, e8, e9, e10;
    Button b1, b2;
    ImageView myImg;
    final int REQUEST_CODE_GALLERY=999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisateur);
        Intent intent = new Intent();
        final String text = intent.getStringExtra(MainActivity.EXTRA_TXT);
        db = new MySQLite(this);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        //e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        e6 = (EditText) findViewById(R.id.e6);
        e8 = (EditText) findViewById(R.id.e8);
        e9 = (EditText) findViewById(R.id.e9);
        e10 = (EditText) findViewById(R.id.e10);
        b1 = (Button) findViewById(R.id.b1);
       myImg=(ImageView)findViewById(R.id.img);
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(organisateur.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_GALLERY);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
               // i.putExtra("org", "org");
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                //String s3 = e3.getText().toString();
                String s4=e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                //String s7 = e7.getText().toString();
                String s8 = e8.getText().toString();
                String s9 = e9.getText().toString();
                String s10 = e10.getText().toString();
                Organisateur orga= new Organisateur();
                byte[] NewEntryImg =imageViewTobyte(myImg);
                orga.setAdresse_organisateur(s6);
                orga.setContact_organisateur(s4);
                orga.setDescription_organisateur(s8);
                orga.setEmail_organisateur(s2);
                orga.setVille_organisateur(s5);
                orga.setPasswd_organisateur(s9);
                orga.setImage_organisateur(NewEntryImg);
                orga.setNom_organisateur(s1);
                if (s1.equals("") || s2.equals("")  || s4.equals("") || s5.equals("") || s6.equals("") ||   s8.equals("") || s9.equals("")|| s10.equals("") ) {
                    Toast.makeText(getApplicationContext(), "empty fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (s9.equals(s10)) {
                        Boolean chkemail = db.chkemailO(s2);
                        if (chkemail==false ) {
                           Boolean insert = db.insertO(orga);
                           // Boolean insert =insertO(orga);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "used mail ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }*/

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                viewImage.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }*/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions , @NonNull int[] grantResults){
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent , REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(getApplicationContext(),"vous n'avez pas les droits", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions , grantResults);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
        Uri uri= data.getData();
        try{
            InputStream inputStream = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            myImg.setImageBitmap(bitmap);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
     }
        super.onActivityResult(requestCode, resultCode , data);
    }
   /* public boolean insertO( Organisateur organisateur ){
        MySQLite db=new MySQLite(this.getApplicationContext());
        db.contentValues.put(Organisateur.getColNom(), organisateur.getNom_organisateur());
        db.contentValues.put(Organisateur.getColEmail(), organisateur.getEmail_organisateur());
        db.contentValues.put(Organisateur.getColPasswd(), organisateur.getPasswd_organisateur());
        db.contentValues.put(Organisateur.getColContact(), organisateur.getContact_organisateur());
        db.contentValues.put(Organisateur.getColVille(), organisateur.getVille_organisateur());
        db.contentValues.put(Organisateur.getColDesc(), organisateur.getDescription_organisateur());
        db.contentValues.put(Organisateur.getColAdresse(), organisateur.getAdresse_organisateur());
       // db.contentValues.put(Organisateur.getColImage(), organisateur.getImage_organisateur());
        long ins = db.dbw.insert(Organisateur.getTableName() , null , db.contentValues);
        if(ins==-1)return false;
        else return true;
    }*/
   private byte[] imageViewTobyte(ImageView image) {
        /*Bitmap bitmapp=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bitmapp.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray= stream.toByteArray();

        return byteArray;*/

       image.buildDrawingCache();
       Bitmap bmap = image.getDrawingCache();
       ByteArrayOutputStream stream= new ByteArrayOutputStream();
       bmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
       byte[] byteArray= stream.toByteArray();

       return byteArray;
        /*private byte[] imageViewTobyte(ImageView image) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            ByteArrayOutputStream blob = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, blob);
        byte[] imag  = blob.toByteArray();
        return imag;*/
    }
}
