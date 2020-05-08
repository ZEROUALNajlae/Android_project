package com.example.myplannerify;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TXT= "com.example.myplannerify.EXTRA_TXT" ;
    MySQLite db;
    EditText e1, e2;
    TextView e3;
    Button b1;
    //String str = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MySQLite(this);



        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (TextView) findViewById(R.id.Register);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String email = e1.getText().toString();
                                      String password = e2.getText().toString();
                                      Boolean ch = db.empssO(email, password);
                                      if(email.equals("")||password.equals("")){
                                          Toast.makeText(getApplicationContext(),"empty fields" , Toast.LENGTH_SHORT).show();
                                      }else {
                                          if (ch == true) {
                                              //hello organisateur
                                              Toast.makeText(getApplicationContext(), "Authenticated Organisator", Toast.LENGTH_SHORT).show();
                                          } else {
                                              Boolean ch1 = db.empssC(email, password);
                                              if (ch1 == true) {
                                                  //hello client
                                                  Intent i =new Intent(MainActivity.this,Home.class);
                                                  // i.putExtra("EXTRA_TXT", "client");
                                                  startActivity(i);
                                                  Toast.makeText(getApplicationContext(), "Authenticated ", Toast.LENGTH_SHORT).show();
                                              } else {
                                                  Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_SHORT).show();
                                              }
                                          }
                                          e1.getText().clear();
                                          e2.getText().clear();
                                      }
                                       //   }
                                         /* if (intent.hasExtra("client")) {
                                              str = intent.getStringExtra("client");
                                              Boolean ch = db.empssC(email, password);
                                              if (ch == true) {
                                                  Toast.makeText(getApplicationContext(), "bien authentifié", Toast.LENGTH_SHORT).show();
                                              } else {
                                                  Toast.makeText(getApplicationContext(), "mot de passe erroné", Toast.LENGTH_SHORT).show();
                                              }
                                          }*/


                                      }
                                  }

        );

    }
    public void ShowAlertDialog(View v){
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setTitle("Plannery");
        alert.setMessage("user type");
        alert.setPositiveButton("client", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i =new Intent(MainActivity.this,register.class);
               // i.putExtra("EXTRA_TXT", "client");
                startActivity(i);
            }
        });
        alert.setNegativeButton("organistor", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i =new Intent(MainActivity.this,organisateur.class);
                //i.putExtra("EXTRA_TXT", "oragnisateur");
                startActivity(i);
            }
        });
        alert.create().show();
    }


    public void ShowAlertDialog1(View v){
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setTitle("Plannery");
        alert.setMessage("user type");
        alert.setPositiveButton("client", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i =new Intent(MainActivity.this,ForgetPasswordC.class);
                // i.putExtra("EXTRA_TXT", "client");
                startActivity(i);
            }
        });
        alert.setNegativeButton("organisator", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i =new Intent(MainActivity.this,ForgetPassword.class);
                //i.putExtra("EXTRA_TXT", "oragnisateur");
                startActivity(i);
            }
        });
        alert.create().show();
    }





}

