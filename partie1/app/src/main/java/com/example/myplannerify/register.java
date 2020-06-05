package com.example.myplannerify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplannerify.database_classes.Client;

public class register extends AppCompatActivity {

    MySQLite db;
    EditText e1 , e2 ,e3, e4, e5, e6;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent intent= new Intent();
        final String  text= intent.getStringExtra(MainActivity.EXTRA_TXT);
        db = new MySQLite(this);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6);
        b1=(Button)findViewById(R.id.b1);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext() , MainActivity.class);
              //  i.putExtra("client", "client");
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();
                String s6=e6.getText().toString();
                Client client = new Client();
                client.setEmail_client(s3);
                client.setNom_client(s1);
                client.setPasswd_client(s5);
                client.setPrenom_client(s2);
                client.setVille_client(s4);
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")){
                    Toast.makeText(getApplicationContext(),"empty fields" , Toast.LENGTH_SHORT).show();
                }else{
                    if(s6.equals(s5)){
                        Boolean chkemail =db.chkemailO(s3);
                        if(chkemail == false){
                            Boolean insert = db.insertC(client);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"successfully registered" , Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"used email " , Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"wrong password" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
